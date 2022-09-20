package com.example.interviewapplication.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.interviewapplication.model.local.dao.RandomStateDao

@Database(entities = [RandomState::class], version = 1)
@TypeConverters(RandomConverter::class)
abstract class RandomDatabase : RoomDatabase() {

    abstract fun randomStateDao(): RandomStateDao

    companion object {

        fun getInstance(applicationContext: Context) = Room.databaseBuilder(
            applicationContext,
            RandomDatabase::class.java,
            "random.db"
        ).build()
    }
}