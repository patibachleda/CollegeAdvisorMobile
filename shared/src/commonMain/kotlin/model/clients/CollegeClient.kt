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

    suspend fun getAllSchools(school: String): Set<String> {
        val page =  client
            .get(Url("https://api.data.gov/ed/collegescorecard/v1/schools.json" +
                    "?api_key=vZUjtZ3hp42sXZtRqL7vVImTI2Z0paH79LlyffSA" +
                    "&fields=latest.school.name" +
                    "&latest.school.name=${school.replace("&", "%26")}" +
                    "&latest.programs.cip_4_digit.credential.title=Bachelor's Degree"))
            .body<SchoolPage>()
            return getAllSchools(page)
    }

    private fun getAllSchools(page: SchoolPage): Set<String> {
        val schools = ArrayList<String>()

        for(result in page.results){
            schools.add(result.latestSchoolName)
        }

        return schools.toSet()
    }

    suspend fun getAllMajors(school: String): HashMap<String, String> {
        val page =  client
            .get(Url("https://api.data.gov/ed/collegescorecard/v1/schools.json" +
                    "?api_key=vZUjtZ3hp42sXZtRqL7vVImTI2Z0paH79LlyffSA"+
                    "&fields=latest.school.name,latest.programs.cip_4_digit.title,latest.programs.cip_4_digit.code"+
                    "&latest.school.name=${school.replace("&", "%26")}"+
                    "&latest.programs.cip_4_digit.credential.title=Bachelor's Degree"))
            .body<MajorPage>()
        return getAllMajors(page, school)
    }

    private fun getAllMajors(page: MajorPage, school: String): HashMap<String, String>{
        val majors = HashMap<String, String>()

        for(result in page.results){
            if(result.latestSchoolName == school){
                for(values in result.latestProgramsCip4Digit!!) {
                    val title = values.title.replace(".", "")
                    val code = values.code
                    majors[title] = code
                }
            }
        }

        return majors
    }

    suspend fun getResults(school: String, code: String): Results? {
        return client
            .get(Url("https://api.data.gov/ed/collegescorecard/v1/schools.json" +
                    "?api_key=vZUjtZ3hp42sXZtRqL7vVImTI2Z0paH79LlyffSA"+
                    "&fields=latest.school.name,latest.cost.tuition.in_state," +
                    "latest.cost.tuition.out_of_state,latest.programs.cip_4_digit.title," +
                    "latest.programs.cip_4_digit.earnings.1_yr.overall_median_earnings," +
                    "latest.aid.median_debt.number.overall" +
                    "&latest.school.name=${school.replace("&", "%26")}"+
                    "&latest.programs.cip_4_digit.code=${code}"+
                    "&latest.programs.cip_4_digit.credential.title=Bachelor's Degree")
            )
            .body<ResultPage>()
            .results[0]
    }

}