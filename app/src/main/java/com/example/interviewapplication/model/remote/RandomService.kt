package com.example.interviewapplication.model.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface RandomService {

    @GET("/api/v1.0/random")
    suspend fun getRandomNumList(
        @Query("min") min: Int,
        @Query("max") max: Int,
        @Query("count") count: Int,
    ): List<Int>

}