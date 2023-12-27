package viewModel

import model.clients.BlogsClient
import model.data.Blog
import model.sharedPreferences.NameStore

class HomeVM {
    private val statisticClient = BlogsClient()
    private val nameStore: NameStore = NameStore()

    fun loadStatistics(): List<Blog>{
        return statisticClient.getStatistics()
    }

    fun loadBudgetingTips(): List<Blog>{
        return statisticClient.getBudgetingTips()
    }

    fun loadCareerPlanning(): List<Blog>{
        return statisticClient.getCareerPlanning()
    }

    fun getName(): String{
        return nameStore.get()
    }

}
