package com.example.kursvalut.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {
    val signalOnRefresh: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }
}