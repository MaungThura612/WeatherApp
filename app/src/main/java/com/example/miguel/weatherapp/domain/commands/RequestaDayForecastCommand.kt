package com.example.miguel.weatherapp.domain.commands

import com.example.miguel.weatherapp.domain.ForecastProvider
import com.example.miguel.weatherapp.domain.model.Forecast

class RequestDayForecastCommand(
        val id: Long,
        private val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}