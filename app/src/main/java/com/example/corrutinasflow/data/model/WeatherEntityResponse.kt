package com.example.corrutinasflow.data.model

data class WeatherEntityResponse(
    var coord: Coord? = null,
    var base: String = "",
    var visibility: Int = 0,
    var main: Main? = null,
    var wind: Wind? = null,
    var clouds: Clouds? = null,
    var dt: Long = 0,
    var sys: Sys? = null,
    var timezone: Int = 0,
    var id: Long = 0,
    var name: String = "",
    var cod: Int = 0
)

data class Coord(
    var lon: Double,
    var lat: Double
)

data class Main(
    var temp: Double,
    var feels_like: Double,
    var temp_min: Double,
    var temp_max: Double,
    var pressure: Int,
    var humidity: Int
)

data class Wind(
    var speed: Double,
    var deg: Int
)

data class Clouds(
    var all: Int
)

data class Sys(
    var type: Int,
    var id: Int,
    var message: Double,
    var country: String,
    var sunrise: Long,
    var sunset: Long
)

