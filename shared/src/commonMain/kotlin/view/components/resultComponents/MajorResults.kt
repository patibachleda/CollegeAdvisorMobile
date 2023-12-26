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
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import view.Utils
import view.theme.green
import viewModel.ResultsUiState

@Composable
fun MajorResults (uiState: ResultsUiState) {
    val utils = Utils()
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
}