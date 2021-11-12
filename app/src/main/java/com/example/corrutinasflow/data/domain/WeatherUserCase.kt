package com.example.corrutinasflow.data.domain

import com.example.corrutinasflow.data.model.WeatherEntityResponse
import com.example.corrutinasflow.data.repository.WeatherRepository
import javax.inject.Inject

class WeatherUserCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend fun getWeatherUserCase(): WeatherEntityResponse = repository.getWeatherRepository()
}