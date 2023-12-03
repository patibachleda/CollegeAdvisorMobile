
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import ui.components.navigation.CalculatorTab
import ui.components.navigation.FavoritesTab
import ui.components.navigation.HomeTab
import ui.theme.backgroundColor
import ui.theme.brown

@Composable
fun App() {
        TabNavigator(HomeTab) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    BottomNavigation (backgroundColor = brown){
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(CalculatorTab)
                        TabNavigationItem(FavoritesTab)
                    }
                },
                content = {
                    Column(
                        modifier = Modifier.padding(it)
                    ){
                        CurrentTab()
                    } },
            )
        }
}