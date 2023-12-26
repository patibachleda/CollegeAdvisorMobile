package model.data

import kotlin.math.ln
import kotlin.math.round

class Calculator {

    fun calculateYears(medianSalary: Float?, loanAmount: Float?, loanInterest: Float): Float{
        // N = -[In (1- [(PV* i)/ PMT_])/ In(1+ _1i)
        // PV = present value
        // PMT = monthly payment
        // i = monthly interest rate

        val paymentAmount = medianSalary?.times(.1f)
        val loanInt = loanInterest/100

        if (loanAmount != null) {
            if (loanAmount != 0f && paymentAmount != 0f) {
                return (
                        -(ln(1 - ((loanAmount * loanInt) /
                                        paymentAmount!!)))
                                / (ln(1 + loanInt)))
            }
        }

        return 0f
    }

    fun displayAdvice(years: Float): String{
        return if (years > 5){
            "Try to pick a more affordable college. This one seems a little too expensive for your degree type. Consider an in-state option!"
        } else{
            "This would be a great path for you!"
        }
    }
}