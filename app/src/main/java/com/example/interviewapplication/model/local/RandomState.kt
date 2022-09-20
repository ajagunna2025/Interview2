package com.example.interviewapplication.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RandomState(
    @PrimaryKey val id: Int = 0,
    val nums: List<Int>
)