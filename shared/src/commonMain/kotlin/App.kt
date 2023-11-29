
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import ui.components.CalculatorTab
import ui.components.FavoritesTab
import ui.components.HomeTab
import ui.theme.backgroundColor

@Composable
fun App() {
        TabNavigator(HomeTab) {
            Scaffold(
//                topBar= {
//                  TopAppBar {
//                      Text("COLLEGE CAREER COST", fontSize = 30.sp, fontFamily = FontFamily.Serif)
//                  }
//                },
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    BottomNavigation (backgroundColor = backgroundColor){
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(CalculatorTab)
                        TabNavigationItem(FavoritesTab)
                    }
                },
                content = { CurrentTab() },
            )
        }
}