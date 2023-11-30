package ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import api.StatisticClient
import cafe.adriel.voyager.core.screen.Screen
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import ui.components.StatisticsList

class Home : Screen{
    private val statisticClient = StatisticClient()

    @Composable
    override fun Content() {
        val statistics = statisticClient.getStatistics()
        Column (
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ){
                    Text(
                        "Hi Pati,",
                        fontSize = 35.sp,
                        fontFamily = FontFamily.Default,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(15.dp)
                    )
                    KamelImage(
                        asyncPainterResource("https://i.pinimg.com/originals/6d/15/4d/6d154d3420dd86c728249fde39434586.jpg"),
                        contentDescription = "main picture",
                        modifier = Modifier
                            .size(80.dp)
                            .align(Alignment.TopEnd)
                            .padding(0.dp, 0.dp, 15.dp, 0.dp)
                    )

                }

                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(15.dp, 0.dp, 15.dp, 0.dp)
                        .fillMaxHeight(),
//                    verticalArrangement = Arrangement.spacedBy(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    KamelImage(
                        asyncPainterResource("https://i.pinimg.com/736x/89/61/51/89615135aea2c6761a30fe784b0dc628.jpg"),
                        contentDescription = "main picture",
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(220.dp)
                    )
                    Text("Resources", fontSize = 25.sp, fontFamily = FontFamily.Default, style = TextStyle(textDecoration = TextDecoration.Underline))
                    StatisticsList(statistics, "Student Loan Statistics")
                    StatisticsList(statistics, "Budgeting Tips")
                    StatisticsList(statistics, "Career Planning")
                }
            }


    }

}
