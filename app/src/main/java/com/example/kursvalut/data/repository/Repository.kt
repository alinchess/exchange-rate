package com.example.kursvalut.data.repository

import com.example.kursvalut.data.api.RetrofitInstanceMono
import com.example.kursvalut.data.api.RetrofitInstancePrivat
import com.example.kursvalut.model.monobank.MonoCurrency
import com.example.kursvalut.model.privatbank.PrivatCurrency
import retrofit2.Response

class Repository {
    suspend fun getPrivatCourse(): Response<PrivatCurrency> {
        return RetrofitInstancePrivat.api.getPrivatCourse()
    }

    suspend fun getMonoCourse(): Response<MonoCurrency> {
        return RetrofitInstanceMono.api.getMonoCourse()
    }
}