package api

import modules.Statistic

class StatisticClient {
    fun getStatistics(): List<Statistic> {
        return listOf(
            Statistic(
                "https://nces.ed.gov/fastfacts/images/2023/Figure5_CUB_flat.svg",
                "Percentage Owed",
            "Among federal student loan borrowers, average amount owed as percentage of amount borrowed as of 4 years after 2015–16 bachelor’s degree completion, by race/ethnicity and Pell Grant receipt: 2020",
                "https://nces.ed.gov/fastfacts/display.asp?id=900"
            ),
            Statistic(
                "https://educationdata.org/wp-content/uploads/369/historic-total-national-student-loan-debt-2023.webp",
                "Total Debt",
                "Student loan debt in the United States totals $1.766 trillion. The debt accumulation rate is slowing, and recent analytics indicate that most consumers manage their student loan debt responsibly.",
                "https://educationdata.org/student-loan-debt-statistics"),
            Statistic(
                "https://educationdata.org/wp-content/uploads/369/student-loan-debt-growth-relative-to-student-borrowers-2023.webp",
                "Loan Debt Growth",
                "Student loan debt is now the second-highest consumer debt category after mortgages. While total student loan debt declined in 2021, individuals may have experienced a debt increase, especially those with private student loans.",
        "https://educationdata.org/student-loan-debt-statistics"
            )

        )
    }

}