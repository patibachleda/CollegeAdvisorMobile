package ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import api.StatisticClient
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import cafe.adriel.voyager.core.model.screenModelScope
import cafe.adriel.voyager.core.screen.Screen
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.launch
import modules.Statistic
import ui.components.StatisticsList
import ui.theme.backgroundColor
import ui.theme.primaryColor
import ui.theme.secondaryColor

class Home : Screen{
    private val statisticClient = StatisticClient()
    @Composable
    override fun Content() {
        val statistics = statisticClient.getStatistics()
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(Color.White),
//            verticalArrangement = Arrangement.spacedBy(50.dp)
        ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ){
                    KamelImage(
                        asyncPainterResource("https://images.pexels.com/photos/267885/pexels-photo-267885.jpeg?auto=compress&cs=tinysrgb&w=1600"),
                        "hi",
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(0.dp, 0.dp, 0.dp, 0.dp)
                    )
                    Text(
                        "COLLEGE CAREER COST",
                        fontSize = 25.sp,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .align(Alignment.Center)
                            .padding(10.dp)
                            .width(300.dp),
                        textAlign = TextAlign.Center
                    )
                }



                Column(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))
                        .background(Color.White)
                        .padding(20.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(50.dp)

                ) {
//                    Text("Embark on a journey of education and career exploration with CareerCraft. We're here to empower you to make informed decisions about your future.",)
                    StatisticsList(statistics, "Student Loan Statistics")
                    StatisticsList(statistics, "Budgeting Tips")
                    StatisticsList(statistics, "Career Planning")
                }
            }


    }

}
