package view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.multiplatform.webview.web.rememberWebViewState
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import model.data.Blog
import view.theme.backgroundColor
import view.theme.coralPink


@Composable
fun StatisticsList(blogs: List<Blog>, title: String) {
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
                    val showBrowser = remember { mutableStateOf(false) }

                    if (showBrowser.value){
                        val state = rememberWebViewState(it.source)
                        BrowserView(state, showBrowser)
                    }

                    Column (
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .border(15.dp, backgroundColor, RoundedCornerShape(8.dp))
                            .height(300.dp)
                            .width(170.dp)
                            .padding(20.dp)
                    ){
                        KamelImage(
                            asyncPainterResource(it.image),
                            "hi",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .background(Color.White)
                                .size(120.dp)
                        )
                        Text(it.title, modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp))
//                        Text(it.source)
                        Button(onClick = { showBrowser.value = true },
                            colors = ButtonDefaults.buttonColors(coralPink)) {
                            Text(text = "Read")
                        }
                    }
                }
            }
        )
    }
}
