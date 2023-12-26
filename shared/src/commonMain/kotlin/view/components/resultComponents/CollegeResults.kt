package view.components.resultComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import view.Utils
import view.theme.cyan
import viewModel.ResultsUiState

@Composable
fun CollegeResults(uiState: ResultsUiState) {
    val utils = Utils()
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
}