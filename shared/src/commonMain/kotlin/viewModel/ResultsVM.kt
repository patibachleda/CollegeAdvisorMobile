package viewModel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import model.data.Calculator
import model.controller.CollegeClient
import model.sharedPreferences.FavoritesStore

data class ResultsUiState(
    val school: String = "",
    val major: String = "",
    val tuitionInState: Long? = 0,
    val tuitionOutState: Long? = 0,
    val avgDebt: Long? = 0,
    val medianEarning: Long? = 0,
    val interestRate: Double = 8.34,
    val time: Double? = 0.0
)

class ResultsVM (school: String, major: String): ViewModel(){
    private val _uiState = MutableStateFlow(ResultsUiState())
    val uiState = _uiState.asStateFlow()
    private val collegeClient = CollegeClient()
    private val calculator = Calculator()
    private val favoritesStore = FavoritesStore()

    private val client = HttpClient{
        install(ContentNegotiation){
            json()
        }
    }

    init {
        _uiState.update {
            it.copy(school = school, major = major)
        }
        getResults()
    }

    override fun onCleared() {
        client.close()
    }

    private fun getResults(){
        viewModelScope.launch {
            val results = collegeClient.getResults(_uiState.value.school, _uiState.value.major)
            if (results != null){
                _uiState.update {
                    it.copy(
                        tuitionInState = results.latestCostTuitionInState,
                        tuitionOutState = results.latestCostTuitionOutOfState,
                        avgDebt = results.latestAidMedianDebtNumberOverall,
                        medianEarning = results.latestProgramsCip4Digit?.get(0)?.earnings?.n1Yr?.overallMedianEarnings ?: 0
                    )
                }
                val time = calculator.calculateYears(_uiState.value.medianEarning, _uiState.value.avgDebt, _uiState.value.interestRate)
                _uiState.update {
                    it.copy(
                        time = time
                    )
                }
            }
        }
    }

    fun addResults(school: String, major: String, years: String){
        favoritesStore.add(school, major, years)
    }

}