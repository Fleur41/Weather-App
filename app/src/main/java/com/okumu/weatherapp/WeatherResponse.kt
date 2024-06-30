package com.okumu.weatherapp

data class WeatherResponse(
    val name: String,
    val weather: List<Weather>,
    val main: Main,
    val wind: Wind,
    val sys: Sys,
    val visibility: Int
)

data class Weather(
    val description: String
)

data class Main(
    val temp: Float,
    val tempMin: Float,
    val tempMax: Float,
    val pressure: Int,
    val humidity: Int
)

data class Wind(
    val speed: Float
)

data class Sys(
    val sunrise: Long,
    val sunset: Long
)
