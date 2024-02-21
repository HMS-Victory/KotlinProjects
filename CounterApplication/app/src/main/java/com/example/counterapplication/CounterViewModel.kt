package com.example.counterapplication

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CounterViewModel(): ViewModel() {
    //in Kotlin it is good practice to name private variables with a '_' at the beginning
    private val _repository: CounterRepository= CounterRepository()
    private val _count= mutableStateOf(_repository.getCounter().count)

    // Expose the count as an immutable state
    val count: MutableState<Int> = _count


    fun increment(){
        _repository.incrementCounter()
        _count.value=_repository.getCounter().count
    }
    fun decrement(){
        _repository.decrementCounter()
        _count.value=_repository.getCounter().count
    }


}