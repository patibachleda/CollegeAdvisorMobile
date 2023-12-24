package view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import view.theme.coralPink
import view.theme.cyan
import view.theme.green

class Favorites : Screen {
    @Composable
    override fun Content() {
        var text by remember { mutableStateOf(TextFieldValue("Student")) }
        Divider(color = coralPink, thickness = 5.dp)

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp, 30.dp, 20.dp, 30.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            KamelImage(
                asyncPainterResource("https://png.pngtree.com/png-clipart/20230418/original/pngtree-student-line-icon-png-image_9065647.png"),
                contentDescription = "profile",
                modifier = Modifier
                    .clip(CircleShape)
                    .border(2.dp, Color.Black, CircleShape)
                    .size(110.dp)
                    .background(green)
            )
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Name") },
                singleLine = true
            )
            Divider(color = coralPink, thickness = 2.dp)

            Text("Favorites", fontSize = 30.sp, fontFamily = FontFamily.Default)
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxSize(),
                content = {
                    items(4) {
                        Column(
                            modifier = Modifier
                                .background(Color.White)
                                .border(4.dp, cyan, RoundedCornerShape(8.dp))
                                .padding(10.dp)

                        ) {
                            Text("College")
                            Text("Major")
                            Text("Good or Bad")
                        }

                    }
                }
            )
        }
    }


}