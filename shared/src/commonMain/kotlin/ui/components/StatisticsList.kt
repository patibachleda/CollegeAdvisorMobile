package ui.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun StatisticsList() {
    LazyRow (
        content = {
            items(15) {
                KamelImage(
                    asyncPainterResource("https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-1080x675.jpg"),
                    "hi"
                )
            }
        }
    )
}