package com.okumu.weatherapp


import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WeatherRepository {

    suspend fun getWeatherData(): Response<WeatherResponse> {
        return RetrofitInstance.weatherApi.getWeather(
            city = "Nairobi", // Replace with the city of your choice or pass it as a parameter
            apiKey = "your_api_key_here" // Replace with your actual API key
        )
    }

    fun formatTime(timeInSeconds: Long): String {
        val date = Date(timeInSeconds * 1000)
        val format = SimpleDateFormat("hh:mm a", Locale.getDefault())
        return format.format(date)
    }
}
