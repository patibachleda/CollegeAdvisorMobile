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
import model.clients.CollegeClient
import model.sharedPreferences.FavoritesStore

data class ResultsUiState(
    val school: String = "",
    val major: String = "",
    val code: String = "",
    val tuitionInState: Float? = 0f,
    val tuitionOutState: Float? = 0f,
    val avgDebt: Float? = 0f,
    var medianEarning: Float? = 0f,
    val interestRate: Float = 5.8f,
    val time: Float? = 0f
)

class ResultsVM (school: String, major: String, code: String?): ViewModel(){
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
        if (code != null){
            _uiState.update {
                it.copy(code = code)
            }
        }
        getResults()
    }

    override fun onCleared() {
        client.close()
    }

    private fun getResults(){
        viewModelScope.launch {
            val results = collegeClient.getResults(_uiState.value.school, _uiState.value.code)
            if (results != null){
                _uiState.update {
                    it.copy(
                        tuitionInState = results.latestCostTuitionInState,
                        tuitionOutState = results.latestCostTuitionOutOfState,
                        avgDebt = results.latestAidMedianDebtNumberOverall,
                        medianEarning = results.latestProgramsCip4Digit?.get(0)?.earnings?.n1Yr?.overallMedianEarnings ?: 0f
                    )
                }

                val time = if(_uiState.value.medianEarning == 0f){
                    calculator.calculateYears(58862f, _uiState.value.avgDebt, _uiState.value.interestRate)
                } else{
                    calculator.calculateYears(_uiState.value.medianEarning, _uiState.value.avgDebt, _uiState.value.interestRate)

                }
                _uiState.update {
                    it.copy(
                        time = time
                    )
                }
            }
        }
    }

    fun addResults(school: String, major: String, code: String){
        _uiState.update {
            it.copy(school = school, major = major, code = code)
        }
        favoritesStore.add(school, major, code)
    }
}