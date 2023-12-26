package view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import view.components.resultComponents.AdviceResults
import view.components.resultComponents.CollegeResults
import view.components.resultComponents.MajorResults
import view.theme.backgroundColor
import view.theme.coralPink
import view.theme.cyan
import viewModel.ResultsVM

class Results(
    selectedSchool: String,
    selectedMajor: String,
    private val showSave: Boolean
) : Screen {
    private val viewModel: ResultsVM = ResultsVM(selectedSchool, selectedMajor)

    @Composable
    override fun Content() {
        val uiState by viewModel.uiState.collectAsState()

        Divider(color = coralPink, thickness = 5.dp)
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(30.dp))
        {
            val navigator: Navigator = LocalNavigator.currentOrThrow

            CollegeResults(uiState)
            MajorResults(uiState)
            AdviceResults(uiState)

            if (showSave){
                Button(
                    onClick = {
                        viewModel.addResults(
                            uiState.school,
                            uiState.major
                        ) },
                    colors = ButtonDefaults.buttonColors(backgroundColor)) {
                    Text("Save Result")
                }
            }

            Button(
                onClick = { navigator.pop() },
                colors = ButtonDefaults.buttonColors(cyan)) {
                Text("Back")
            }
        }
    }

}