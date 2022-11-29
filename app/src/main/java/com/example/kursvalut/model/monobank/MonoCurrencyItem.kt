package com.example.kursvalut.model.monobank

data class MonoCurrencyItem(
    val currencyCodeA: Int,
    val currencyCodeB: Int,
    val date: Int,
    val rateBuy: Double,
    val rateCross: Double,
    val rateSell: Double
)