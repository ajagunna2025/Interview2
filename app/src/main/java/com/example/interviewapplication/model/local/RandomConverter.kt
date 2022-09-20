package com.example.interviewapplication.model.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RandomConverter {

    @TypeConverter
    fun toJson(nums: List<Int>) : String? {
        return Gson().toJson(nums)
    }

    @TypeConverter
    fun fromJson(numsString: String) : List<Int> {
        val listType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(numsString, listType)
    }
}