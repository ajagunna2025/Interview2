package com.example.interviewapplication.di

import android.content.Context
import com.example.interviewapplication.model.local.RandomDatabase
import com.example.interviewapplication.model.local.dao.RandomStateDao
import com.example.interviewapplication.model.remote.RandomService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class RandomModule {

    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://www.randomnumberapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun providesRandomService(retrofit: Retrofit) : RandomService = retrofit.create()

    @Provides
    fun providesRandomDatabase(
        @ApplicationContext context: Context
    ) : RandomDatabase = RandomDatabase.getInstance(context)

    @Provides
    fun providesRandomDao(db: RandomDatabase): RandomStateDao = db.randomStateDao()
}