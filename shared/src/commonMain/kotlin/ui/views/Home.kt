package ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import ui.components.StatisticsList

class Home : Screen{
    @Composable
    override fun Content() {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(50.dp)){
            // title
            Text("COLLEGE CAREER COST", fontSize = 30.sp, fontFamily = FontFamily.Monospace)
            // text 1
            Text("Embark on a journey of education and career exploration with CareerCraft. We're here to empower you to make informed decisions about your future. Whether you're navigating college choices, selecting a degree, or planning your career path, CareerCraft is your trusty companion.\n" +
                    "\n")
            Text("Student Loan Statistics")
            StatisticsList()
//            Text("\uD83C\uDF93 **Unlock Your Potential:**\n" +
//                    "Discover the true value of your education. Our intuitive calculator analyzes college costs versus potential salaries, guiding you towards financial smart decisions.\n" +
//                    "\n" +
//                    "\uD83D\uDD0D **Explore, Compare, Decide:**\n" +
//                    "Dive into the world of possibilities. Explore different degrees, colleges, and career paths. Our comparison tools provide insights to help you make choices that align with your aspirations.\n" +
//                    "\n" +
//                    "\uD83C\uDF10 **Navigate Your Future:**\n" +
//                    "Ready to take control of your future? Let's get started on crafting a path that's uniquely yours. Welcome to CareerCraft, where informed choices lead to boundless opportunities!\n" +
//                    "\n" +
//                    "---\n" +
//                    "\n" )
            // text 2
        }
    }

}
