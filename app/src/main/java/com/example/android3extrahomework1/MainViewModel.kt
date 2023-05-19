package com.example.android3extrahomework1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int> = _number

    var count = 0

    fun setPlus(){
        count ++
        _number.value = count
    }

    fun setMinus(){
        count --
        _number.value = count
    }
}