package com.example.interviewapplication.model.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.interviewapplication.model.local.RandomState
import kotlinx.coroutines.flow.Flow

@Dao
interface RandomStateDao {

    @Query("SELECT * FROM randomstate LIMIT 1")
    fun getAll() : Flow<RandomState>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(randomState: RandomState)
}