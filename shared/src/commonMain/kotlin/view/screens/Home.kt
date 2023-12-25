package view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.controller.BlogsClient
import cafe.adriel.voyager.core.screen.Screen
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.rememberWebViewState
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import view.components.StatisticsList
import view.theme.coralPink
import viewModel.HomeVM

class Home : Screen{
    private val viewModel = HomeVM()

    @Composable
    override fun Content() {
        val statistics = viewModel.loadStatistics()
        val budgetingTips = viewModel.loadBudgetingTips()
        val careerPlanning = viewModel.loadCareerPlanning()

        Column (
            modifier = Modifier
                .verticalScroll(rememberScrollState()
                )
        ) {
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ){
                    Divider(color = coralPink, thickness = 5.dp)
                    Text(
                        "Hi ${viewModel.getName()}!",
                        fontSize = 35.sp,
                        fontFamily = FontFamily.Default,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(20.dp, 0.dp, 20.dp, 0.dp)
                    )

                    KamelImage(
                        asyncPainterResource("https://i.pinimg.com/564x/e5/d5/c4/e5d5c4b5acb462a4080d3bf6f5f11652.jpg"),
                        contentDescription = "books icon",
                        modifier = Modifier
                            .size(80.dp)
                            .align(Alignment.TopEnd)
                            .padding(0.dp, 0.dp, 20.dp, 0.dp)
                    )
                }

            Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(15.dp, 0.dp, 15.dp, 0.dp)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                KamelImage(
                        asyncPainterResource("https://i.pinimg.com/736x/58/36/83/583683ba6efc83a7053427f18a2b3d75.jpg"),
                        contentDescription = "main picture",
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(220.dp)
                    )

                    Text("Resources",
                        fontSize = 25.sp,
                        fontFamily = FontFamily.Default,
                        style = TextStyle(textDecoration = TextDecoration.Underline)
                    )
                    StatisticsList(statistics, "Student Loan Statistics")
                    StatisticsList(budgetingTips, "Budgeting Tips")
                    StatisticsList(careerPlanning, "Career Planning")
                }
            }


    }

}
