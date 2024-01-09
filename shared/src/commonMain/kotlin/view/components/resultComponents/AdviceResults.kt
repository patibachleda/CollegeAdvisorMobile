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
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import model.data.Calculator
import view.Utils
import view.theme.coralPink
import view.theme.cyan
import viewModel.ResultsUiState

@Composable
fun AdviceResults(uiState: ResultsUiState) {
    val calculator = Calculator()
    val utils = Utils()

    var medianEarning = uiState.medianEarning!!
    if (medianEarning == 0f){
        medianEarning = 58862f
    }
    val avgDebt = uiState.avgDebt!!
    val interest = uiState.interestRate

    var selectedIncome by rememberSaveable(uiState.medianEarning) { mutableFloatStateOf(medianEarning) }
    var selectedLoan by rememberSaveable(uiState.avgDebt) { mutableFloatStateOf(avgDebt) }
    var selectedInterest by rememberSaveable(uiState.interestRate) { mutableFloatStateOf(interest) }

    val years = calculator.calculateYears(selectedIncome, avgDebt, interest)
    var calculatedYears by rememberSaveable(uiState.time) { mutableFloatStateOf(years) }


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
        Text(utils.formatMoney(selectedLoan.toLong()),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Slider(
            value = selectedLoan,
            onValueChange = { selectedLoan = it;
                calculatedYears = calculator.calculateYears(selectedIncome, selectedLoan, selectedInterest)
            },
            valueRange = avgDebt.times(.5f) .. avgDebt.times(5f),
            colors = SliderDefaults.colors(
                thumbColor = cyan,
                activeTrackColor = cyan,
                inactiveTrackColor = cyan,
            ),
        )
        Text("Experts suggest contributing 8-10% of your salary towards your loan (we'll use 10% for this calculation).")
        Text("*If there was no reported data for your major at this school, we will take the" +
                "average salary of a college graduate of $58,862 " +
                "[source: www.bankrate.com ]",
            fontSize = 10.sp)
        Text("So, taking your expected median earning after 1 year with your degree of:")
        Text(utils.formatMoney(selectedIncome.toLong()),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Slider(
            value = selectedIncome,
            onValueChange = { selectedIncome = it;
                calculatedYears = calculator.calculateYears(selectedIncome, selectedLoan, selectedInterest)
            },
            valueRange = medianEarning.times(.8f) .. medianEarning.times(1.3f),
            colors = SliderDefaults.colors(
                thumbColor = cyan,
                activeTrackColor = cyan,
                inactiveTrackColor = cyan,
            ),
        )
        Text("And an interest rate of:")
        Text("${utils.formatOneDecimal(selectedInterest)}%",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Slider(
            value = selectedInterest,
            onValueChange = { selectedInterest = it;
                calculatedYears = calculator.calculateYears(selectedIncome, selectedLoan, selectedInterest)
            },
            valueRange = interest.times(.6f) .. interest.times(1.4f),
            colors = SliderDefaults.colors(
                thumbColor = cyan,
                activeTrackColor = cyan,
                inactiveTrackColor = cyan,
            ),
        )
        Text("It would take you about:")
        Text("${utils.formatOneDecimal(calculatedYears)} years",
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
            Text(calculator.displayAdvice(calculator.calculateYears(selectedIncome, selectedLoan, selectedInterest)),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp)
            )

        }
    }
}