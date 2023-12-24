package model.controller

import model.data.Blog

class BlogsClient {
    fun getStatistics(): List<Blog> {
        return listOf(
            Blog(
                "https://nces.ed.gov/fastfacts/images/2023/Figure5_CUB_flat.svg",
                "Percentage Owed",
                "https://nces.ed.gov/fastfacts/display.asp?id=900"
            ),
            Blog(
                "https://educationdata.org/wp-content/uploads/369/historic-total-national-student-loan-debt-2023.webp",
                "Total Debt",
                "https://educationdata.org/student-loan-debt-statistics"),
            Blog(
                "https://educationdata.org/wp-content/uploads/369/student-loan-debt-growth-relative-to-student-borrowers-2023.webp",
                "Loan Debt Growth",
        "https://educationdata.org/student-loan-debt-statistics"
            )

        )
    }
    fun getBudgetingTips(): List<Blog> {
        return listOf(
            Blog(
                "https://nces.ed.gov/fastfacts/images/2023/Figure5_CUB_flat.svg",
                "Percentage Owed",
                "https://nces.ed.gov/fastfacts/display.asp?id=900"
            ),
            Blog(
                "https://educationdata.org/wp-content/uploads/369/historic-total-national-student-loan-debt-2023.webp",
                "Total Debt",
                "https://educationdata.org/student-loan-debt-statistics"
            ),
            Blog(
                "https://educationdata.org/wp-content/uploads/369/student-loan-debt-growth-relative-to-student-borrowers-2023.webp",
                "Loan Debt Growth",
                "https://educationdata.org/student-loan-debt-statistics"
            )

        )
    }
    fun getCareerPlanning(): List<Blog> {
        return listOf(
            Blog(
                "https://nces.ed.gov/fastfacts/images/2023/Figure5_CUB_flat.svg",
                "Percentage Owed",
                "https://nces.ed.gov/fastfacts/display.asp?id=900"
            ),
            Blog(
                "https://educationdata.org/wp-content/uploads/369/historic-total-national-student-loan-debt-2023.webp",
                "Total Debt",
                "https://educationdata.org/student-loan-debt-statistics"),
            Blog(
                "https://educationdata.org/wp-content/uploads/369/student-loan-debt-growth-relative-to-student-borrowers-2023.webp",
                "Loan Debt Growth",
                "https://educationdata.org/student-loan-debt-statistics"
            )

        )
    }

}