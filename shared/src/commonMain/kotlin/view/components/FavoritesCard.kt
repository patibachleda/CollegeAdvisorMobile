package view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import model.data.Favorites
import view.screens.Results
import view.theme.coralPink
import view.theme.cyan
import view.theme.green
import viewModel.FavoritesVM

@Composable
fun FavoritesCard (it: Favorites) {
    val navigator = LocalNavigator.currentOrThrow
    val favoritesVM = FavoritesVM()

    Column(
        modifier = Modifier
            .background(Color.White)
            .border(4.dp, green, RoundedCornerShape(8.dp))
            .padding(10.dp)
    ){
        Text("Saved Result",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text("School:",
            modifier = Modifier
                .padding(0.dp, 10.dp,0.dp,0.dp),
            fontWeight = FontWeight.Bold
        )
        Text(it.school, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(0.dp, 2.dp,0.dp,10.dp)
        )

        Text("Major:",
            modifier = Modifier,
            fontWeight = FontWeight.Bold
        )
        Text(it.major, modifier = Modifier
            .padding(0.dp, 2.dp,0.dp,10.dp),
        )
        Button(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
                onClick = { navigator.push(Results(it.school, it.major, false)) },
                colors = ButtonDefaults.buttonColors(cyan)
        ) {
            Text("View Details", fontSize = 12.sp)
        }

        Button(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.End),
            onClick = { favoritesVM.remove(it.school, it.major) },
            colors = ButtonDefaults.buttonColors(coralPink)
        ) {
            Text("Remove", fontSize = 12.sp)
        }

    }
}