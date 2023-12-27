package model.clients

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.Url
import io.ktor.serialization.kotlinx.json.json
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

    private fun getAllMajors(page: MajorPage): HashMap<String, String>{
        val majors = HashMap<String, String>()

        for(result in page.results){
            for(values in result.latestProgramsCip4Digit!!) {
                val title = values.title.replace(".", "")
                val code = values.code
                majors[title] = code
            }
        }

        return majors
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

    suspend fun getAllMajors(school: String): HashMap<String, String> {
        val page =  client
            .get("https://api.data.gov/ed/collegescorecard/v1/schools.json" +
                    "?api_key=vZUjtZ3hp42sXZtRqL7vVImTI2Z0paH79LlyffSA"+
                    "&fields=latest.programs.cip_4_digit.title,latest.programs.cip_4_digit.code"+
                    "&latest.school.name=${school}"+
                    "&latest.programs.cip_4_digit.credential.title=Bachelor's Degree")
            .body<MajorPage>()
        return getAllMajors(page)
    }

    suspend fun getResults(school: String, code: String): Results? {
        return client
            .get(Url("https://api.data.gov/ed/collegescorecard/v1/schools.json" +
                    "?api_key=vZUjtZ3hp42sXZtRqL7vVImTI2Z0paH79LlyffSA"+
                    "&fields=latest.school.name,latest.cost.tuition.in_state," +
                    "latest.cost.tuition.out_of_state,latest.programs.cip_4_digit.title," +
                    "latest.programs.cip_4_digit.earnings.1_yr.overall_median_earnings," +
                    "latest.aid.median_debt.number.overall" +
                    "&latest.school.name=${school}"+
                    "&latest.programs.cip_4_digit.code=${code}"+
                    "&latest.programs.cip_4_digit.credential.title=Bachelor's Degree")
            )
            .body<ResultPage>()
            .results[0]
    }

}