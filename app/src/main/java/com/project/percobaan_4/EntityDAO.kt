package com.project.percobaan_4

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "dataset")
data class Dataset(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val namaDataset: String,
    val namaKolom: String,
    val tipeData: String,
    val status: String
)

@Dao
interface DatasetDao {
    @Insert
    suspend fun insert(dataset: Dataset)

    @Query("SELECT * FROM dataset")
    fun getAllDatasets(): Flow<List<Dataset>>

    @Delete
    suspend fun delete(dataset: Dataset)
}