package com.example.kursvalut.data.api

import com.example.kursvalut.model.monobank.MonoCurrency
import retrofit2.Response
import retrofit2.http.GET

interface ApiServiceMono {
    @GET("bank/currency")
    suspend fun getMonoCourse(): Response<MonoCurrency>

}