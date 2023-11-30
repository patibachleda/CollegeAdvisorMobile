package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import modules.Statistic

@Composable
fun StatisticsList(statistics: List<Statistic>, title: String) {

    Column(
        modifier = Modifier.fillMaxWidth().padding(0.dp, 25.dp, 0.dp, 25.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(title, fontFamily = FontFamily.Default)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
//            modifier = Modifier.background(Color.LightGray),
            content = {
                items(statistics) {
                    var expanded by remember {
                        mutableStateOf(false)
                    }

                    var enlarged by remember {
                        mutableStateOf(false)
                    }
                    if (enlarged) {
                        ImageDialog(
                            icon = it.image,
                            dialogTitle = it.shortDescription,
                            dialogText = it.description,
                            onConfirmation = {enlarged = false},
                            onDismissRequest = {enlarged = false})
                    }

                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
//                            .clip(shape = CircleShape)
                            .background(Color.LightGray)
                            .padding(10.dp)
                    ){
                        KamelImage(
                            asyncPainterResource(it.image),
                            "hi",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color.White)
                                .size(120.dp)
                                .clickable { enlarged = true  }
                        )

//                        Text(it.shortDescription + "\n\n" + it.description,
//                            style = MaterialTheme.typography.caption,
//                            maxLines = if (!expanded) 1 else Int.MAX_VALUE,
//                            modifier = Modifier
//                                .animateContentSize()
//                                .width(150.dp)
//                        )
//
//                        Button(onClick = { expanded = !expanded }) {
//                            Icon(
//                                if (expanded) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.ArrowDropDown,
//                                contentDescription = "See more"
//                            )
//                        }
                    }
                }

            }
        )
    }
}

