package com.example.kursvalut.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursvalut.data.repository.Repository
import com.example.kursvalut.model.monobank.MonoCurrency
import com.example.kursvalut.model.privatbank.PrivatCurrency
import kotlinx.coroutines.launch
import retrofit2.Response

class FirstViewModel: ViewModel() {
    private var repository = Repository()
    val privatList: MutableLiveData<Response<PrivatCurrency>> = MutableLiveData()
    val monoList: MutableLiveData<Response<MonoCurrency>> = MutableLiveData()

    fun getPrivatCurrency() {
        viewModelScope.launch {
        privatList.value = repository.getPrivatCourse()
        }
    }
    fun getMonoCurrency() {
        viewModelScope.launch {
            monoList.value = repository.getMonoCourse()
        }
    }
}