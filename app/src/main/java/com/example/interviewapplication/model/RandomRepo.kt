package com.example.interviewapplication.model

import com.example.interviewapplication.model.local.RandomState
import com.example.interviewapplication.model.local.dao.RandomStateDao
import com.example.interviewapplication.model.remote.RandomService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

class RandomRepo @Inject constructor(
    private val service: RandomService,
    private val dao: RandomStateDao
) {
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    val randomState = dao.getAll().distinctUntilChanged()

    suspend fun getRandomNumList(
        min: Int,
        max: Int,
        count: Int,
    ) {
        val randomNums = service.getRandomNumList(min, max, count)
        scope.launch {
            dao.insert(RandomState(nums = randomNums))
        }
    }
}