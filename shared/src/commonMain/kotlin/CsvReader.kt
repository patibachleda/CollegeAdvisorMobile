//package api
//
//import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
//import java.io.File
//
///**
// * Example of reading a csv.
// */
//fun main() {
//    // Read all line by line
//    csvReader().open("src/main/resources/test.csv") {
//        readAllAsSequence().forEach { row ->
//            //Do something
//            println(row) // [value 1, value 2]
//        }
//    }
//
//    // Read all with header
//    val rows: List<Map<String, String>> = csvReader().readAllWithHeader(File("src/main/resources/test.csv"))
//    println(rows) // [{column 1=value 1, column 2=value 2}, {column 1=value 3, column 2=value 4}]
//
//    // Do some processing line by line
//    for(row in rows) {
//        println(row["column 1"])
//    }
//}
//
