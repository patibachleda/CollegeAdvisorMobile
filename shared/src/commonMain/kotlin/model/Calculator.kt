package model

class Calculator {

    fun calculateYears(loan: Loan, payment: Payment){

    }

    fun displayAdvice(years: Int): String{
        return if (years > 5){
            "Consider a more affordable college!"
        } else{
            "This would be a great path for you!"
        }
    }
}