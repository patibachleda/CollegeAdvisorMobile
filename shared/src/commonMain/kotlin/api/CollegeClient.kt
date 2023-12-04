package api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import model.Page
import kotlin.math.ceil

class CollegeClient {

    private val client = HttpClient{
        install(ContentNegotiation){
            json()
        }
    }

    suspend fun getAllInformation(): List<Page>{
        val total = 6543.00
        val perPage = 50.00

        val totalPages = ceil(total/perPage).toInt()

        val response = ArrayList<Page>()

        for(pageNumber in 0..totalPages){
            val page = client
                .get("https://api.data.gov/ed/collegescorecard/v1/schools.json" +
                        "?api_key=vZUjtZ3hp42sXZtRqL7vVImTI2Z0paH79LlyffSA"+
                        "&per_page=$perPage"+
                        "&fields=latest.school.name,latest.cost.tuition.in_state,"+
                        "latest.cost.tuition.out_of_state,latest.programs.cip_4_digit.title,"+
                        "latest.programs.cip_4_digit.earnings.1_yr.overall_median_earnings"+
                        "&page=$pageNumber")
                .body<Page>()
            response.add(page)
        }

        return response
    }
    fun getAllSchools(pages: List<Page>): List<String>{
        val schools = ArrayList<String>()

        if (pages != null) {
            for (page in pages){
                for(result in page.results){
                    schools.add(result.latestSchoolName)
                }
            }
        }

        return schools
    }

//    fun getAllMajors(school: String): List<String>{
//        val majors = ArrayList<String>()
//
//        if (pages != null) {
//            for (page in pages){
//                for(result in page.results){
//                    if (result.latestSchoolName == school){
//                        majors.add()
//                    }
//                }
//            }
//        }
//
//        return majors
//    }
//
//    fun getSchool(school: String): School{
//        val majors = ArrayList<String>()
//
//        if (pages != null) {
//            for (page in pages){
//                for(result in page.results){
//                    if (result.latestSchoolName == school){
//                        majors.add()
//                    }
//                }
//            }
//        }
//
//        return majors
//    }

}