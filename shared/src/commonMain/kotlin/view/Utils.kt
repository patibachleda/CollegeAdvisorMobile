package view

import kotlinx.serialization.StringFormat
import kotlin.math.round

class Utils{
    fun formatMoney(number: Long?): String {
        return "$" + number
            .toString()
            .reversed()
            .chunked(3)
            .joinToString(",")
            .reversed()
    }

    fun formatOneDecimal(number: Float?): Double {
        return round(number!! * 10.0)/10.0
    }

    fun nullDataCheck(number: Float?): String{
        return if (number == 0f){
            "No data"
        } else{
            formatMoney(number!!.toLong())
        }
    }
}
