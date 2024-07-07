package com.project.percobaan_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.project.percobaan_4.ui.theme.Percobaan_4Theme

class DataScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Percobaan_4Theme {
                DatasetListScreen()
            }
        }
    }
}

@Composable
fun DatasetListScreen(datasetViewModel: DatasetViewModel = viewModel()) {
    val datasets by datasetViewModel.allDatasets.collectAsState(initial = emptyList())

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(
            text = "Dataset List",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .size(500.dp, 65.dp)
                .align(Alignment.CenterHorizontally)
                .background(color = Color.Blue)
                .padding(50.dp, 10.dp)

        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (datasets.isNotEmpty()) {
                datasetViewModel.deleteFirstDataset(datasets[0])
            }
        }) {
            Text(text = "Hapus Baris Pertama")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(datasets) { dataset ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = dataset.namaDataset)
                    Text(text = dataset.namaKolom)
                    Text(text = dataset.tipeData)
                    Text(text = dataset.status)
                }
            }
        }
    }
}

@Composable
fun Greeting5(name: String, modifier: Modifier = Modifier) {
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    Percobaan_4Theme {
        Greeting5("Android")
    }
}