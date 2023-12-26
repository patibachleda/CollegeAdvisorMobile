package model.data

import kotlin.math.ln
import kotlin.math.round

class Calculator {

    fun calculateYears(medianSalary: Long?, loanAmount: Long?, loanInterest: Double): Double{
        // N = -[In (1- [(PV* i)/ PMT_])/ In(1+ _1i)
        // PV = present value
        // PMT = monthly payment
        // i = monthly interest rate

        val paymentAmount = medianSalary?.times(.1)
        val loanInt = loanInterest/100

        if (loanAmount != null) {
            if (loanAmount.toInt() != 0 && paymentAmount?.toInt() != 0) {
                return round( -(ln(
                    1 - ((loanAmount * loanInt) /
                            paymentAmount!!)
                )) /
                        (ln(1 + loanInt)))
            }
        }

        return 0.0
    }

    fun displayAdvice(years: Double): String{
        return if (years > 5){
            "Try to pick a more affordable college. This one seems a little too expensive for your degree type. Consider an in-state option!"
        } else{
            "This would be a great path for you!"
        }
    }
}