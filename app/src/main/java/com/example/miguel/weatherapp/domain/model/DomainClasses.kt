package com.example.miguel.weatherapp.domain.model

/**
 * Created by miguel on 1/11/17.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)
data class Forecast(val date: String, val description: String, val high: Int, val low: Int)