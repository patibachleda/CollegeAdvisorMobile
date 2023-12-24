package viewModel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import model.data.Favorites
import model.sharedPreferences.FavoritesStore
import model.sharedPreferences.NameStore

data class FavoritesUiState(
    var favorites: MutableList<Favorites> = mutableListOf()
)

data class NameUiState(
    var name: String = "Student"
)

class FavoritesVM: ViewModel(){
    private val favoritesStore: FavoritesStore = FavoritesStore()
    private val _uiStateFavorites = MutableStateFlow(FavoritesUiState())
    val uiStateFavorites = _uiStateFavorites.asStateFlow()

    private val nameStore: NameStore = NameStore()
    private val _uiStateName = MutableStateFlow(NameUiState())
    val uiStateName = _uiStateName.asStateFlow()


    fun addFavorite(school: String, major: String, years: String){
        favoritesStore.add(school, major, years)
    }

    fun getFavorites(school: String, major: String, years: String): String{
        viewModelScope.launch {
            val favorite = favoritesStore.get(school, major, years)
            _uiStateFavorites.value.favorites.add(favorite)
            val favorites = _uiStateFavorites.value.favorites
            _uiStateFavorites.update {
                it.copy(favorites = favorites)
            }
        }
        return school
    }

    fun addName(name: String){
        nameStore.add(name)
    }

    fun getName(): String{
        val name = nameStore.get()

        viewModelScope.launch {
            _uiStateName.update {
                it.copy(name = name)
            }
        }
        return name
    }

}