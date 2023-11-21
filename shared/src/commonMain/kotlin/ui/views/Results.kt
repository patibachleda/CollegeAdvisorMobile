package ui.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

class Results(): Screen {
    @Composable
    override fun Content() {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .border(1.dp, Color.Red, RectangleShape)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(50.dp))
        {
            val navigator: Navigator = LocalNavigator.currentOrThrow

            Text("RESULTS", fontSize = 30.sp, fontFamily = FontFamily.Monospace)
            Column(
                modifier = Modifier.border(1.dp, Color.Green, RectangleShape),
            ){
                Text("College Cost")
                Text("Tuition per Year")
                Text("Average debt after graduating")
            }
            Column(
                modifier = Modifier.border(1.dp, Color.Green, RectangleShape),
            ){
                Text("Jobs for Degree")
            }
            Column(
                modifier = Modifier.border(1.dp, Color.Green, RectangleShape),
            ){
                Text("How Long Will It Take to Pay Off Loans")
                Text("Experts suggest contributing 8-10% of your salary towards your loan")
            }
            Column(
                modifier = Modifier.border(1.dp, Color.Green, RectangleShape),
            ){
                Text("Advice")
            }
            Button(onClick = { navigator.push(Results()) }) {
                Text("Submit")
            }
            Button(onClick = { navigator.pop() }) {
                Text("Back")
            }
        }
    }

}