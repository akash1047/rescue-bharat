package github.akash1047.rescuebharat

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import github.akash1047.rescuebharat.ui.theme.RescueBharatTheme

@Composable
fun UserSelection() {
    currentActivity = LocalContext.current as Activity
//    val current = LocalContext.current as Activity
    val context = LocalContext.current

    RescueBharatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surface
        ) {
            // TODO: check the typography in buttons
            Column(
                modifier = Modifier.padding(bottom = 40.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(modifier = Modifier.fillMaxWidth(0.6f), onClick = { /*TODO*/ }) {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.admin),
                            contentDescription = "open admin page",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "Login as Administrator",
                            modifier = Modifier.weight(1.0f),
                            textAlign = TextAlign.Center
                        )
                    }
                }

                FilledTonalButton(modifier = Modifier.fillMaxWidth(0.6f), onClick = {
                    context.startActivity(Intent(context, CitizenActivity::class.java))
                }) {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "open citizen login page",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "Login as Citizen",
                            modifier = Modifier.weight(1.0f),
                            textAlign = TextAlign.Center
                        )
                    }
                }

                OutlinedButton(modifier = Modifier.fillMaxWidth(0.6f), onClick = {
//                    current.finish()
                }) {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "open citizen signup page",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "Create Citizen profile",
                            modifier = Modifier.weight(1.0f),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}
