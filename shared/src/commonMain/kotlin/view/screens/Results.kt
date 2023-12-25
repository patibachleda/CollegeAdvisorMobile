package view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import model.data.Calculator
import view.components.Utils
import view.theme.coralPink
import view.theme.cyan
import view.theme.green
import viewModel.ResultsVM

class Results(
    selectedSchool: String,
    selectedMajor: String
) : Screen {
    private val viewModel: ResultsVM = ResultsVM(selectedSchool, selectedMajor)
    private val utils: Utils = Utils()
    private val calculator: Calculator = Calculator()
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

            Text("Results",
                fontSize = 30.sp,
                fontFamily = FontFamily.Default)
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .fillMaxWidth()
                    .border(25.dp, cyan, RoundedCornerShape(8.dp))
                    .padding(40.dp)
            ){
                Text("College Cost",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Text(uiState.school,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                KamelImage(
                    asyncPainterResource("https://i.pinimg.com/736x/82/d9/f1/82d9f1ce8f892bf2fe726265fb8fece6.jpg"),
                    contentDescription = "university",
                    modifier = Modifier
                        .size(150.dp)
                        .align(Alignment.CenterHorizontally)

                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text("Tuition per Year (in-state):",
                        modifier = Modifier
                            .padding(0.dp, 0.dp,0.dp,20.dp)
                            .align(Alignment.CenterStart)
                    )
                    Text(utils.nullDataCheck(uiState.tuitionInState), modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(0.dp, 0.dp,0.dp,20.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text("Tuition per Year (out-of-state):",
                        modifier = Modifier
                            .padding(0.dp, 0.dp,0.dp,20.dp)
                            .align(Alignment.CenterStart)
                    )
                    Text(utils.nullDataCheck(uiState.tuitionOutState), modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(0.dp, 0.dp,0.dp,20.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text("Average debt after graduating:",
                        modifier = Modifier
                            .padding(0.dp, 0.dp,0.dp,20.dp)
                            .align(Alignment.CenterStart)
                    )
                    Text(utils.nullDataCheck(uiState.avgDebt), modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(0.dp, 0.dp,0.dp,20.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .fillMaxWidth()
                    .border(25.dp, green, RoundedCornerShape(8.dp))
                    .padding(40.dp)
            ){
                Text("Selected Major",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Text(uiState.major,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(0.dp, 0.dp,0.dp,20.dp)
                )
                KamelImage(
                    asyncPainterResource("https://i.pinimg.com/736x/98/81/35/9881359b793e5e6b9d1344e8819e35b1.jpg"),
                    "graduate",
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text("Median Earning:",
                        modifier = Modifier
                            .padding(0.dp, 20.dp, 0.dp, 20.dp)
                            .align(Alignment.CenterStart)
                    )
                    Text(utils.nullDataCheck(uiState.medianEarning), modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(0.dp, 0.dp,0.dp,20.dp)
                    )
                }
            }
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
                Text("Experts suggest contributing 8-10% of your salary towards your loan.")
                Text("So... taking your expected median earning after 1 year with your degree of:")
                Text("$60,000",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Text("And an interest rate of:")
                Text("8.34 %",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Text("It would take you about:")
                Text(calculator.calculateYears(uiState.medianEarning, uiState.avgDebt, 8.34).toString(),
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
                    Text("Try to pick a more affordable college. This one seems a little too expensive for your degree type. Consider an in-state option!",
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .align(Alignment.CenterHorizontally)
                            .padding(10.dp)
                    )

                }
            }

            Button(onClick = {
                viewModel.addResults(
                    uiState.school,
                    uiState.major,
                    calculator.calculateYears(uiState.medianEarning, uiState.avgDebt, 8.34).toString()
                ) }) {
                Text("Save Result")
            }
            Button(onClick = { navigator.pop() }) {
                Text("Back")
            }
        }
    }

}