package view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import model.data.Blog
import view.theme.backgroundColor
import view.theme.coralPink


@Composable
fun StatisticsList(blogs: List<Blog>, title: String, color: Color) {
//    val context = LocalContext.current
//    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")) }

    Column(
        modifier = Modifier.fillMaxWidth().padding(0.dp, 25.dp, 0.dp, 25.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(title, fontFamily = FontFamily.Default)
        Divider(color = coralPink, thickness = 2.dp)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            content = {
                items(blogs) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
//                            .clip(shape = CircleShape)
                            .clip(RoundedCornerShape(8.dp))
                            .background(backgroundColor)
                            .width(170.dp)
                            .padding(10.dp)
                    ){
                        KamelImage(
                            asyncPainterResource("https://i.pinimg.com/564x/e5/d5/c4/e5d5c4b5acb462a4080d3bf6f5f11652.jpg"),
                            "hi",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .background(Color.White)
                                .size(120.dp)
                        )
                        Text(it.title)
                        Text(it.source)
//                        Button(onClick = {
//                            val url = "http://www.example.com"
//                            val i = Intent(Intent.ACTION_VIEW)
//                            i.setData(android.net.Uri.parse(url))
//                            startActivity(i)
//                        }) {
//                            Text(text = "Navigate to Google!")
//                        }
                    }
                }

            }
        )
    }
}
