package model

import kotlin.math.ln

class Calculator {

    fun calculateYears(medianSalary: Long?, loanAmount: Long?, loanInterest: Double): Double{
        // N = -[In (1- [(PV* i)/ PMT_])/ In(1+ _1i)
        // PV = present value
        // PMT = monthly payment
        // i = monthly interest rate

        val paymentAmount = medianSalary?.times(.1)
        val loanInt = loanInterest/100

        if (loanAmount != null) {
            return -(ln(
                1 - ((loanAmount * loanInt) /
                        paymentAmount!!)
            )) /
                    (ln(1 + loanInt))
        }

        return 0.0
    }

    fun displayAdvice(years: Int): String{
        return if (years > 5){
            "Consider a more affordable college!"
        } else{
            "This would be a great path for you!"
        }
    }
}