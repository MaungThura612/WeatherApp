package com.example.miguel.weatherapp.domain.commands

import com.example.miguel.weatherapp.data.ForecastRequest
import com.example.miguel.weatherapp.domain.mappers.ForecastDataMaper
import com.example.miguel.weatherapp.domain.model.ForecastList

/**
 * Created by miguel on 5/11/17.
 */
class RequestForecastCommand(private val zipCode : String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val request =  ForecastRequest(zipCode)
        return ForecastDataMaper().convertFromDataModel(request.execute())
    }
}