package com.okumu.weatherapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city:   String,
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = "your_api_key_here"
    ): Response<WeatherResponse>
}