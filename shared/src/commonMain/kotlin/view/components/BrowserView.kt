package view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.WebViewState

@Composable
fun BrowserView(state: WebViewState, showBrowser: MutableState<Boolean>) {

    if(showBrowser.value){
        Dialog(onDismissRequest = { showBrowser.value = false }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(750.dp)
                    .padding(5.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                WebView(state,
                    modifier = Modifier
                        .fillMaxWidth())
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(10.dp, 0.dp),
                            horizontalArrangement = Arrangement.End,
                    ) {
                        Button(
                            onClick = { showBrowser.value = false },
                            colors = ButtonDefaults.buttonColors(Color.Red)
                        ) {
                            Text("X")
                        }
                    }
                }
        }
    }
}