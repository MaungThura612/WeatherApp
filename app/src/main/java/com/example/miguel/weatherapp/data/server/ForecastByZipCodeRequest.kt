package com.example.miguel.weatherapp.data.server

import com.google.gson.Gson
import java.net.URL

/**
 *
 * Created by miguel on 1/11/17.
 *
 */
class ForecastByZipCodeRequest(private val zipCode:Long) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URL}&APPID=${APP_ID}&zip="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}