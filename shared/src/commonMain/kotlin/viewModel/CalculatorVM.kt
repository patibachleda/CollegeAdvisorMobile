package viewModel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import model.clients.CollegeClient

data class SchoolsUiState(
  var selectedSchool: String = "",
  val schools: List<String> = emptyList(),
  val majors: HashMap<String, String> = hashMapOf()
)

class CalculatorVM(selectedSchool: String): ViewModel() {
  private val _uiState = MutableStateFlow(SchoolsUiState())
  val uiState = _uiState.asStateFlow()
  private val collegeClient = CollegeClient()

  private val client = HttpClient{
    install(ContentNegotiation){
      json()
    }
  }

  init {
      updateSchools(selectedSchool)
  }

  override fun onCleared() {
    client.close()
  }

  fun updateSchools(subString: String){
    viewModelScope.launch {
      val schools = collegeClient.getAllSchools(subString).toList()
      _uiState.update {
        it.copy(schools = schools)
      }
    }
  }

  fun updateMajors(selectedSchool: String){
    viewModelScope.launch {
      val majors = collegeClient.getAllMajors(selectedSchool)
      _uiState.update {
        it.copy(selectedSchool = selectedSchool,
                majors = majors)
      }
    }
  }

}