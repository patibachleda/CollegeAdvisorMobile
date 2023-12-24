
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import view.components.navigation.CalculatorTab
import view.components.navigation.FavoritesTab
import view.components.navigation.HomeTab
import view.theme.brown

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