package view.components

class Utils{
    fun formatMoney(number: Long?): String {
        return "$" + number
            .toString()
            .reversed()
            .chunked(3)
            .joinToString(",")
            .reversed()
    }

    fun nullDataCheck(number: Long?): String{
        return if (number?.toInt() == 0){
            "No data available"
        } else{
            formatMoney(number)
        }
    }
}
