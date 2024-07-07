package com.project.percobaan_4

import android.app.Application
import android.net.Uri
import android.os.Environment
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.File

class FileUploaderViewModel(application: Application) : AndroidViewModel(application) {
    private val _fileList = mutableStateListOf<File>()
    val fileList: List<File> = _fileList

    fun addFile(uri: Uri) {
        viewModelScope.launch {
            val file = uri.toFile(getApplication<Application>())
            _fileList.add(file)
        }
    }

    fun removeFile(file: File) {
        _fileList.remove(file)
        file.delete()
    }
}

fun Uri.toFile(application: Application): File {
    val inputStream = application.contentResolver.openInputStream(this)
    val file = File(application.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), this.lastPathSegment ?: "tempFile")

    file.outputStream().use { outputStream ->
        inputStream?.copyTo(outputStream)
    }
    return file
}