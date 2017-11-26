package com.example.miguel.weatherapp.domain.commands

import com.example.miguel.weatherapp.data.server.ForecastByZipCodeRequest
import com.example.miguel.weatherapp.domain.mappers.ForecastDataMapper

import com.example.miguel.weatherapp.domain.model.ForecastList

/**
 * Created by miguel on 5/11/17.
 */
class RequestForecastCommand(private val zipCode : Long) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastByZipCodeRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
    }
}