package com.example.corrutinasflow.data.repository

import com.example.corrutinasflow.data.model.WeatherEntityResponse
import com.example.corrutinasflow.data.network.service.WeatherService
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherService: WeatherService
) {
    suspend fun getWeatherRepository(): WeatherEntityResponse =
        this.weatherService.getWeatherService()

}