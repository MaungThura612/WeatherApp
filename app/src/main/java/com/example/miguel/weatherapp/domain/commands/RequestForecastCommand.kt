package com.example.miguel.weatherapp.domain.commands

import com.example.miguel.weatherapp.domain.ForecastProvider

import com.example.miguel.weatherapp.domain.model.ForecastList

/**
 * Created by miguel on 5/11/17.
 */
class RequestForecastCommand(
        private val zipCode: Long,
        private val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}