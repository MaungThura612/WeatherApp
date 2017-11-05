package com.example.miguel.weatherapp.domain.commands

/**
 *
 * Created by miguel on 1/11/17.
 *
 */

interface Command<out T> {
    fun execute() : T
}