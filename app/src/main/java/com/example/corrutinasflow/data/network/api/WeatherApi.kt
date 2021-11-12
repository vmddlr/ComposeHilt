package com.example.corrutinasflow.data.network.api

import com.example.corrutinasflow.data.model.WeatherEntityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    suspend fun getWeatherByIdApi(
        @Query("id") idCity: Long,
        @Query("units") units: String?,
        @Query("appid") appid: String?
    ): Response<WeatherEntityResponse>
}