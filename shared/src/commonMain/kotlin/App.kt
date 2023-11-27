
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import ui.components.CalculatorTab
import ui.components.FavoritesTab
import ui.components.HomeTab

@Composable
fun App() {
    MaterialTheme {
        TabNavigator(HomeTab) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    BottomNavigation {
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(CalculatorTab)
                        TabNavigationItem(FavoritesTab)
                    }
                },
                content = { CurrentTab() },
            )
        }
    }
}