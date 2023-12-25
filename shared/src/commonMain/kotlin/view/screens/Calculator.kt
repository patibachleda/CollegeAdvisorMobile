package view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import schools
import view.components.DropDown
import view.theme.coralPink
import view.theme.cyan
import viewModel.CalculatorVM

class Calculator : Screen{
  private var selectedSchoolParam = ""
  private val viewModel: CalculatorVM = CalculatorVM(selectedSchoolParam)

  @Composable
  override fun Content() {
    var selectedSchool by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()
    val navigator = LocalNavigator.currentOrThrow

    LaunchedEffect(selectedSchool) {
      selectedSchoolParam = selectedSchool
      viewModel.updateMajors(selectedSchool)
    }

    Divider(color = coralPink, thickness = 5.dp)

    Column (
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(20.dp),
      verticalArrangement = Arrangement.spacedBy(30.dp)
    )
    {

      Text("Analyze", fontSize = 35.sp, fontFamily = FontFamily.Default)
      Divider(color = coralPink, thickness = 2.dp)

      Text("Step 1: ", fontSize = 25.sp, fontFamily = FontFamily.Default, modifier = Modifier.align(Alignment.Start))

      selectedSchool = DropDown(uiState.schools.toSet(), "College")
      Text("Step 2: ", fontSize = 25.sp, fontFamily = FontFamily.Default, modifier = Modifier.align(Alignment.Start))

      var selectedMajor = DropDown(uiState.majors, "Major")
      Text("Step 2: ", fontSize = 25.sp, fontFamily = FontFamily.Default, modifier = Modifier.align(Alignment.Start))

      Button(
        onClick = { navigator.push(Results(selectedSchool, selectedMajor, true)) },
        colors = ButtonDefaults.buttonColors(cyan)
      ) { Text("Calculate") }
    }
  }

  }