package com.example.interviewapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewapplication.model.RandomRepo
import com.example.interviewapplication.model.local.RandomState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: RandomRepo) : ViewModel() {

    private val _randomState = MutableStateFlow(RandomState(nums = listOf()))
    val randomState : StateFlow<RandomState> get() = _randomState

    init {
        viewModelScope.launch {
            repo.randomState.filterNotNull().collect {
                _randomState.value = it
            }
        }
    }

    fun fetchRandomNums(
        min: Int = 100,
        max: Int = 1000,
        count: Int = 5,
    ) {
        viewModelScope.launch {
            repo.getRandomNumList(min, max, count)
        }
    }

}