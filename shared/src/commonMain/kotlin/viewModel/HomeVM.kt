package viewModel

import model.controller.BlogsClient
import model.data.Blog

class HomeVM {
    private val statisticClient = BlogsClient()
    private val favoritesVM = FavoritesVM()

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
        return favoritesVM.getName()
    }

}
