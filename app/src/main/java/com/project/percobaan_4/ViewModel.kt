package com.project.percobaan_4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DatasetViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DatasetRepository

    init {
        val datasetDao = AppDatabase.getDatabase(application).datasetDao()
        repository = DatasetRepository(datasetDao)
    }

    val allDatasets: Flow<List<Dataset>> = repository.allDatasets

    fun insert(dataset: Dataset) = viewModelScope.launch {
        repository.insert(dataset)
    }

    fun deleteFirstDataset(dataset: Dataset) = viewModelScope.launch {
        repository.delete(dataset)
    }
}