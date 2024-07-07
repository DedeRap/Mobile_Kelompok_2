package com.project.percobaan_4

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.project.percobaan_4.ui.theme.Percobaan_4Theme
import java.io.File

class FileUploadActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FileUploaderScreen()
        }
    }
}

@Composable
fun FileUploaderScreen(fileUploaderViewModel: FileUploaderViewModel = viewModel()) {
    var fileName by remember { mutableStateOf("No file selected") }
    val activity = LocalContext.current as Activity
    val getFile = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            fileUploaderViewModel.addFile(it)
            fileName = it.lastPathSegment ?: "Unknown file"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            getFile.launch("*/*")
        }) {
            Text(text = "Select File")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = fileName, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(fileUploaderViewModel.fileList) { file ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = file.name,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Button(onClick = { openFile(activity, file) }) {
                        Text(text = "Open")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { fileUploaderViewModel.removeFile(file) }) {
                        Text(text = "Delete")
                    }
                }
            }
        }
    }
}

fun openFile(activity: Activity, file: File) {
    val uri = FileProvider.getUriForFile(activity, "${activity.packageName}.fileprovider",file)
    val intent = Intent(Intent.ACTION_VIEW)
    intent.setDataAndType(uri, "*/*")
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    activity.startActivity(intent)
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Percobaan_4Theme {
        Greeting3("Android")
    }
}