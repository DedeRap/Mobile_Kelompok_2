package com.project.percobaan_4

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Percobaan_4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column {
        Text(
            text = "Pilih Menu Aktivitas!",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium,
            modifier = modifier
                .size(500.dp, 65.dp)
                .align(Alignment.CenterHorizontally)
                .background(color = Color.Blue)
                .padding(50.dp, 10.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = {val intent = Intent(context,FileUploadActivity::class.java)
            ContextCompat.startActivity(context, intent, null)}, modifier = modifier
            .size(300.dp, 60.dp)
            .align(Alignment.CenterHorizontally)) {
            Text(text = "Upload File",
                style = MaterialTheme.typography.displaySmall)
        }

        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {val intent = Intent(context,DataEntryActivity::class.java)
            ContextCompat.startActivity(context, intent, null)}, modifier = modifier
            .size(300.dp, 60.dp)
            .align(Alignment.CenterHorizontally)) {
            Text(text = "Data Entry",
                style = MaterialTheme.typography.displaySmall)
        }

        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {val intent = Intent(context,DataScreenActivity::class.java)
            ContextCompat.startActivity(context, intent, null)}, modifier = modifier
            .size(300.dp, 60.dp)
            .align(Alignment.CenterHorizontally)) {
            Text(text = "Dataset",
                style = MaterialTheme.typography.displaySmall)
        }

        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {val intent = Intent(context,DatasetAPIActivity::class.java)
            ContextCompat.startActivity(context, intent, null)}, modifier = modifier
            .size(300.dp, 60.dp)
            .align(Alignment.CenterHorizontally)) {
            Text(text = "Dataset API",
                style = MaterialTheme.typography.displaySmall)
        }

        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {val intent = Intent(context,MainActivity::class.java)
            ContextCompat.startActivity(context, intent, null)}, modifier = modifier
            .size(300.dp, 60.dp)
            .align(Alignment.CenterHorizontally)) {
            Text(text = "Log Out",
                style = MaterialTheme.typography.displaySmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Percobaan_4Theme {
        Greeting2("Android")
    }
}