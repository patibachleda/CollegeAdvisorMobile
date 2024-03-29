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

    fun removeFavorite(school: String, major: String){
       favoritesStore.remove(school, major)
    }

    fun getFavorites(): MutableList<Favorites>{
        val favorites = favoritesStore.getAll()

        viewModelScope.launch {
            _uiStateFavorites.update {
                it.copy(favorites = favorites)
            }
        }

        return favorites
    }

}