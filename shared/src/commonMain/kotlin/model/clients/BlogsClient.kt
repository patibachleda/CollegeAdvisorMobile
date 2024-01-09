package model.clients

import model.data.Blog

class BlogsClient {
    fun getStatistics(): List<Blog> {
        return listOf(
            Blog(
                "https://static.wixstatic.com/media/f738fe_5c1214e215fc466f8901db7fa09a4bd2~mv2.gif",
                "Student Loan Debt Statistics",
                "https://educationdata.org/student-loan-debt-statistics"),
            Blog(
                "https://static.wixstatic.com/media/f738fe_5c1214e215fc466f8901db7fa09a4bd2~mv2.gif",
                "2023 Student Loan Debt Statistics: Average Student Loan Debt",
                "https://www.forbes.com/advisor/student-loans/average-student-loan-debt-statistics/"
            ),
            Blog(
                "https://static.wixstatic.com/media/f738fe_5c1214e215fc466f8901db7fa09a4bd2~mv2.gif",
                "Student Debt",
                "https://nces.ed.gov/fastfacts/display.asp?id=900"
            ),
        )
    }
    fun getBudgetingTips(): List<Blog> {
        return listOf(
            Blog(
                "https://creazilla-store.fra1.digitaloceanspaces.com/cliparts/35010/books-clipart-xl.png",
                "How to Find a College That Fits You",
                "https://bigfuture.collegeboard.org/plan-for-college/find-your-dream-college/choose-a-college/how-to-find-a-college-that-fits-you"
            ),
            Blog(
                "https://creazilla-store.fra1.digitaloceanspaces.com/cliparts/35010/books-clipart-xl.png",
                "10 Steps To Picking the Right School",
                "https://www.usnews.com/education/best-colleges/slideshows/10-steps-to-picking-the-right-school"
            ),
            Blog(
                "https://creazilla-store.fra1.digitaloceanspaces.com/cliparts/35010/books-clipart-xl.png",
                "How to Pick a College: 7 Factors to Consider",
                "https://thebestschools.org/resources/how-to-pick-a-college/"
            )

        )
    }
    fun getCareerPlanning(): List<Blog> {
        return listOf(
            Blog(
                "https://png.pngtree.com/png-clipart/20221110/original/pngtree-career-picture-image_3634495.png",
                "10 Tips for Choosing a Major",
                "https://edwardscampus.ku.edu/blog/10-tips-choosing-major"
            ),
            Blog(
                "https://png.pngtree.com/png-clipart/20221110/original/pngtree-career-picture-image_3634495.png",
                "Top Considerations When Choosing a College Major",
                "https://admissions.usf.edu/blog/top-considerations-when-choosing-a-college-major"),
            Blog(
                "https://png.pngtree.com/png-clipart/20221110/original/pngtree-career-picture-image_3634495.png",
                "The Ultimate Guide to Choosing a College Major",
                "https://blog.collegeboard.org/the-ultimate-guide-to-choosing-a-college-major"
            )

        )
    }

}