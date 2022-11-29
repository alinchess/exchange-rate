package com.example.kursvalut.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceMono {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://api.monobank.ua")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    val api: ApiServiceMono by lazy {
        retrofit.create(ApiServiceMono::class.java)
    }
}