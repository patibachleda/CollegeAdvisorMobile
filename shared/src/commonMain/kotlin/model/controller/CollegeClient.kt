package model.controller

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import model.data.MajorPage
import model.data.ResultPage
import model.data.Results
import model.data.SchoolPage

class CollegeClient {

    private val client = HttpClient{
        install(ContentNegotiation){
            json()
        }
    }

    suspend fun getAllInformation(): List<String>{
        val schools = mutableListOf<String>()
        for(pageNumber in 0..66){
            val response = client
                .get("https://api.data.gov/ed/collegescorecard/v1/schools.json?" +
                        "api_key=vZUjtZ3hp42sXZtRqL7vVImTI2Z0paH79LlyffSA" +
                        "&per_page=99" +
                        "&fields=latest.school.name" +
                        "&page=${pageNumber}")
                .body<SchoolPage>()

            for (school in response.results){
                schools.add(pageNumber, school.latestSchoolName)
            }

        }
        return schools
    }

    private fun getAllSchools(page: SchoolPage): Set<String> {
        val schools = ArrayList<String>()

        for(result in page.results){
            schools.add(result.latestSchoolName)
        }

        return schools.toSet()
    }

    private fun getAllMajors(page: MajorPage): Set<String>{
        val majors = ArrayList<String>()

        for(result in page.results){
            for(values in result.jsonObject.values) {
                for (major in values.jsonArray) {
                    if (major.jsonObject.values.toMutableList()[0].jsonPrimitive.content.isNotBlank()) {
                        majors.add(major.jsonObject.values.toMutableList()[0].jsonPrimitive.content.replace(".", ""))
                    }

                }
            }
        }

        return majors.toSet()
    }

    suspend fun getAllSchools(school: String): Set<String> {
        val page =  client
            .get("https://api.data.gov/ed/collegescorecard/v1/schools.json" +
                    "?api_key=vZUjtZ3hp42sXZtRqL7vVImTI2Z0paH79LlyffSA" +
                    "&fields=latest.school.name" +
                    "&latest.school.name=${school}" +
                    "&latest.programs.cip_4_digit.credential.title=Bachelor's Degree")
            .body<SchoolPage>()
            return getAllSchools(page)
    }

    suspend fun getAllMajors(school: String): Set<String> {
        val page =  client
            .get("https://api.data.gov/ed/collegescorecard/v1/schools.json" +
                    "?api_key=vZUjtZ3hp42sXZtRqL7vVImTI2Z0paH79LlyffSA"+
                    "&fields=latest.programs.cip_4_digit.title"+
                    "&latest.school.name=${school}"+
                    "&latest.programs.cip_4_digit.credential.title=Bachelor's Degree")
            .body<MajorPage>()
        return getAllMajors(page)
    }

    suspend fun getResults(school: String, major: String): Results? {
        return client
            .get("https://api.data.gov/ed/collegescorecard/v1/schools.json" +
                    "?api_key=vZUjtZ3hp42sXZtRqL7vVImTI2Z0paH79LlyffSA"+
                    "&fields=latest.school.name,latest.cost.tuition.in_state," +
                    "latest.cost.tuition.out_of_state,latest.programs.cip_4_digit.title," +
                    "latest.programs.cip_4_digit.earnings.1_yr.overall_median_earnings," +
                    "latest.aid.median_debt.number.overall" +
                    "&latest.school.name=${school}"+
                    "&latest.programs.cip_4_digit.title=${major}."+
                    "&latest.programs.cip_4_digit.credential.title=Bachelor's Degree"
            )
            .body<ResultPage>()
            .results[0]


//            if (response.results.isNotEmpty()){ //Error here because college api sucks, results [] if no median earnings
//                response.results[0]
//            }
//            return null
    }

}