package ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import api.CollegeClient
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ui.components.DropDown
import ui.theme.coralPink
import ui.theme.cyan

class Calculator : Screen{
  @Composable
  override fun Content() {
    LaunchedEffect(Unit){
      val collegeClient = CollegeClient()
      print(collegeClient.getAllSchools())
    }
    Divider(color = coralPink, thickness = 5.dp)

    Column (
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(20.dp),
      verticalArrangement = Arrangement.spacedBy(30.dp)
    )
    {
      val navigator: Navigator = LocalNavigator.currentOrThrow


      Text("Analyze", fontSize = 35.sp, fontFamily = FontFamily.Default)
      Divider(color = coralPink, thickness = 2.dp)

      Text("Step 1: ", fontSize = 25.sp, fontFamily = FontFamily.Default, modifier = Modifier.align(Alignment.Start))

      DropDown(listOf("1", "2"), "College")
      Text("Step 2: ", fontSize = 25.sp, fontFamily = FontFamily.Default, modifier = Modifier.align(Alignment.Start))

      DropDown(listOf("1", "2"), "Major")
      Text("Step 3: ", fontSize = 25.sp, fontFamily = FontFamily.Default, modifier = Modifier.align(Alignment.Start))

      Button(
        onClick = { navigator.push(Results()) },
        colors = ButtonDefaults.buttonColors(cyan)
      )
      {
        Text("Calculate")
      }
    }
  }

}