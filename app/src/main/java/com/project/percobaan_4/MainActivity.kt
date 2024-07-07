package com.project.percobaan_4

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.project.percobaan_4.ui.theme.Percobaan_4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Percobaan_4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Row {
        Column {
            Spacer(modifier = Modifier.height(100.dp))
            Text(
                text = "Dataset Management",
                fontSize = 30.sp,
                fontWeight = FontWeight.Medium,
                modifier = modifier
                    .size(500.dp, 100.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(45.dp, 10.dp)
            )

            Text(
                text = "Silahkan Klik Mulai",
                fontWeight = FontWeight.Medium,
                modifier = modifier
                    .size(500.dp, 70.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(120.dp, 0.dp)
            )

            Button(onClick = {val intent = Intent(context,MenuActivity::class.java)
                ContextCompat.startActivity(context, intent, null)}, modifier = modifier
                .size(300.dp, 65.dp)
                .align(Alignment.CenterHorizontally)) {
                Text(text = "Mulai",
                    style = MaterialTheme.typography.displaySmall)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Percobaan_4Theme {
        Greeting("Android")
    }
}