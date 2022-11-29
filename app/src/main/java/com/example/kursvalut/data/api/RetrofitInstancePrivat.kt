package com.example.kursvalut.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstancePrivat {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://api.privatbank.ua")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    val api: ApiServicePrivat by lazy {
        retrofit.create(ApiServicePrivat::class.java)
    }
}