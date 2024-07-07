package com.project.percobaan_4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

@Database(entities = [Dataset::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun datasetDao(): DatasetDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

class DatasetRepository(private val datasetDao: DatasetDao) {
    val allDatasets: Flow<List<Dataset>> = datasetDao.getAllDatasets()

    suspend fun insert(dataset: Dataset) {
        datasetDao.insert(dataset)
    }

    suspend fun delete(dataset: Dataset) {
        datasetDao.delete(dataset)
    }
}