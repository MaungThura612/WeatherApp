package com.example.miguel.weatherapp.domain

import com.example.miguel.weatherapp.domain.model.ForecastList

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

}