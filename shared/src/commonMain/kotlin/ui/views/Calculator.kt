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
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ui.components.DropDown

class Calculator : Screen{
  @Composable
  override fun Content() {
    Column (
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(20.dp),
      verticalArrangement = Arrangement.spacedBy(50.dp)
    )
    {
      val navigator: Navigator = LocalNavigator.currentOrThrow

      Text("COLLEGE COST ANALYZER", fontSize = 25.sp, fontFamily = FontFamily.SansSerif)
      DropDown(listOf("1", "2"), "College")
      DropDown(listOf("1", "2"), "Major")
      Button(onClick = { navigator.push(Results()) }) {
        Text("Calculate")
      }
    }
  }

}