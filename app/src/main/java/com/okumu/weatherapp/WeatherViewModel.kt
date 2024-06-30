package com.okumu.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherViewModel: ViewModel() {
    private val repository = WeatherRepository()

    private val _weatherData = MutableLiveData<WeatherResponse?>()
    val weatherData: MutableLiveData<WeatherResponse?>
        get() = _weatherData

    private val _sunriseTime = MutableLiveData<String>()
    val sunriseTime: LiveData<String>
        get() = _sunriseTime

    private val _sunsetTime = MutableLiveData<String>()
    val sunsetTime: LiveData<String>
        get() = _sunsetTime

    init {
        fetchWeatherData()
    }

    private fun fetchWeatherData(){
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO){
                    repository.getWeatherData()
                }
                if (response.isSuccessful){
                    response.body()?.let{
                        _weatherData.value = it
                        _sunriseTime.value = repository.formatTime(it.sys.sunrise)
                        _sunsetTime.value = repository.formatTime(it.sys.sunset)
                    }
                } else{
                    // Handle unsuccessful response
                    _weatherData.value = null // Example: Setting value to null
                }
            } catch (e: Exception){
                // Handle network or coroutine exceptions
                _weatherData.value = null // Example: Setting value to null
            }
        }
    }
}