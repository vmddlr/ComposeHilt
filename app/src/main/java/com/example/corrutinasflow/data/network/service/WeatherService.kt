package com.example.corrutinasflow.data.network.service

import com.example.corrutinasflow.data.model.WeatherEntityResponse
import com.example.corrutinasflow.data.network.api.WeatherApi
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WeatherService @Inject constructor(
    private val weatherApi: WeatherApi
) {

    suspend fun getWeatherService(): WeatherEntityResponse = withContext(Dispatchers.IO) {
        val response = weatherApi.getWeatherByIdApi(
            3530597,
            "metric",
            "04782f44b3865c8c013aeeff3c94ecdf"
        )
        response.body() ?: WeatherEntityResponse()
    }
}