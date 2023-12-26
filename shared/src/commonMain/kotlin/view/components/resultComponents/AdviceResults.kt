package view.components.resultComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import model.data.Calculator
import view.theme.coralPink
import view.theme.cyan
import viewModel.ResultsUiState

@Composable
fun AdviceResults(uiState: ResultsUiState) {
    val calculator = Calculator()
    var selectedIncome by rememberSaveable { mutableFloatStateOf(uiState.medianEarning!!.toFloat()) }
    var selectedLoan by rememberSaveable { mutableFloatStateOf(uiState.avgDebt!!.toFloat()) }
    var selectedInterest by rememberSaveable { mutableStateOf(uiState.interestRate.toFloat()) }

    Column(
    modifier = Modifier
    .clip(RoundedCornerShape(8.dp))
    .background(Color.White)
    .fillMaxWidth()
    .border(25.dp, coralPink, RoundedCornerShape(8.dp))
    .padding(40.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Text("How Long Will It Take to Pay Off Loans?",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(0.dp, 0.dp,0.dp,10.dp)
        )
        KamelImage(
            asyncPainterResource("https://i.pinimg.com/736x/29/3e/51/293e51dcfc2eea36a18c0f98a464a538.jpg"),
            "thought",
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text("Assuming your loan will be what the average at this school is")
        Text(selectedLoan.toString(),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Slider(
            value = selectedLoan,
            onValueChange = { selectedLoan = it },
            valueRange = selectedLoan.times(.5f) .. selectedLoan.times(2f),
            colors = SliderDefaults.colors(
                thumbColor = cyan,
                activeTrackColor = cyan,
                inactiveTrackColor = cyan,
            ),
        )
        Text("Experts suggest contributing 8-10% of your salary towards your loan.")
        Text("So, taking your expected median earning after 1 year with your degree of:")
        Text(selectedIncome.toString(),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Slider(
            value = selectedIncome,
            onValueChange = { selectedIncome = it },
            valueRange = selectedIncome.times(.8f) .. selectedIncome.times(1.2f),
            colors = SliderDefaults.colors(
                thumbColor = cyan,
                activeTrackColor = cyan,
                inactiveTrackColor = cyan,
            ),
        )
        Text("And an interest rate of:")
        Text(selectedInterest.toString(),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Slider(
            value = selectedInterest,
            onValueChange = { selectedInterest = it },
            valueRange = selectedInterest.times(.8f) .. selectedInterest.times(1.2f),
            colors = SliderDefaults.colors(
                thumbColor = cyan,
                activeTrackColor = cyan,
                inactiveTrackColor = cyan,
            ),
        )
        Text("It would take you about:")
        Text("${calculator.calculateYears(uiState.medianEarning, uiState.avgDebt, 8.34)} years",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text("To pay off your loans",
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 10.dp)
        )
        Column (
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            Text("Advice",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Text(calculator.displayAdvice(calculator.calculateYears(uiState.medianEarning, uiState.avgDebt, 8.34)),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp)
            )

        }
    }
}