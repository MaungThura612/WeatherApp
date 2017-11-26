package com.example.miguel.weatherapp.domain

import com.example.miguel.weatherapp.domain.model.Forecast
import com.example.miguel.weatherapp.domain.model.ForecastList

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
    fun requestDayForecast(id: Long): Forecast?
}