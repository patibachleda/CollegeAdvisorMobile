package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import modules.Statistic
import ui.theme.primaryColor
import ui.theme.secondaryColor

@Composable
fun StatisticsList(statistics: List<Statistic>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text("STUDENT LOAN STATISTICS", style = MaterialTheme.typography.overline)
//        Text("*Click to expand*", style = MaterialTheme.typography.subtitle2)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                items(statistics) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.background(primaryColor).padding(10.dp)
                    ){
                        KamelImage(
                            asyncPainterResource(it.image),
                            "hi",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(170.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .background(Color.White)
                        )
                        Text(it.shortDescription, style = MaterialTheme.typography.caption) }
                }

            }
        )
    }
}
