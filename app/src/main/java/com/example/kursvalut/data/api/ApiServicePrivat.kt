package com.example.kursvalut.data.api

import com.example.kursvalut.model.privatbank.PrivatCurrency
import retrofit2.Response
import retrofit2.http.GET

interface ApiServicePrivat {
    @GET("p24api/pubinfo?exchange&json&coursid=11")
    suspend fun getPrivatCourse(): Response<PrivatCurrency>

}