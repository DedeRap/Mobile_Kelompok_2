package com.project.percobaan_4

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.percobaan_4.ui.theme.Percobaan_4Theme
import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

class DataEntryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Percobaan_4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting4("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting4(name: String, datasetViewModel: DatasetViewModel = viewModel(), modifier: Modifier = Modifier) {
    val context = LocalContext.current
    // val sharedPreferences: SharedPreferences = context.getSharedPreferences("MeanObjPrefs", Context.MODE_PRIVATE)

    var Nama_Dataset by remember { mutableStateOf("") }
    var Nama_Kolom by remember { mutableStateOf("") }
    var Tipe_Data by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedStatus by remember { mutableStateOf("") }
    val statusOptions = listOf("Selesai", "Berlangsung", "Gagal")

    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Blue)) {
            Text(text = "Dataset Create",
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp)
            )
        }

        OutlinedTextField(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            value = Nama_Dataset,
            onValueChange = { Nama_Dataset = it },
            label = { Text("Nama Dataset") }
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            value = Nama_Kolom,
            onValueChange = { Nama_Kolom = it },
            label = { Text("Nama Kolom") }
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            value = Tipe_Data,
            onValueChange = { Tipe_Data = it },
            label = { Text("Tipe Data") }
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded}
        ) {
            OutlinedTextField(
                readOnly = true,
                value = selectedStatus,
                onValueChange = {},
                label = { Text("Status") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                statusOptions.forEach { status ->
                  DropdownMenuItem(
                      text = { Text(status) },
                      onClick = {
                      selectedStatus = status
                      expanded = false
                      }
                  )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                      datasetViewModel.insert(
                          Dataset(
                          namaDataset = Nama_Dataset,
                          namaKolom = Nama_Kolom,
                          tipeData = Tipe_Data,
                          status = selectedStatus
                      ))
            },
            modifier = Modifier
                .width(135.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Save")
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Button(
                onClick = { val intent = Intent(context, DataScreenActivity::class.java)
                context.startActivity(intent)
                }
            ) {
                Text(text = "Lihat Dataset")
            }
        }
    }
}

private fun savePreferences(
    sharedPreferences: SharedPreferences,
    Nama_Dataset: String,
    Nama_Kolom: String,
    Tipe_Data: String,
    selectedStatus: String
) {
    with(sharedPreferences.edit()) {
        putString("Nama_Dataset", Nama_Dataset)
        putString("Nama_Kolom", Nama_Kolom)
        putString("Tipe_Data", Tipe_Data)
        putString("Status", selectedStatus)
        apply()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    Percobaan_4Theme {
        Greeting4("Android")
        DatasetListScreen()
    }
}