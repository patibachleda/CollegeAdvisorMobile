package ui.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.components.DropDown

@Composable
fun Calculator(){
  Column (
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .border(1.dp, Color.Red, RectangleShape)
      .fillMaxWidth()
      .fillMaxHeight()
      .padding(20.dp),
      verticalArrangement = Arrangement.spacedBy(50.dp)){
    Text("COLLEGE COST ANALYZER", fontSize = 25.sp, fontFamily = FontFamily.Monospace)
    DropDown()
    DropDown()
    var text by remember { mutableStateOf("Click a button") }
    Text(text)
    Button(onClick = { text = "Button 1 Clicked" }) {
      Text("Filled")
    }
  }
}