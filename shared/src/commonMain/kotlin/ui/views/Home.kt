package ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class Home(): Screen{
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Column (){
            // title
            Text("COLLEGE CAREER COST", fontSize = 30.sp, fontFamily = FontFamily.Monospace)
            // text 1
            // text 2
        }
    }

}
