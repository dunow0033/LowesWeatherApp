package com.example.lowesweatherapp.viewmodel

import androidx.lifecycle.*
import com.example.lowesweatherapp.model.HourlyWeather
import com.example.lowesweatherapp.repo.WeatherRepo
import com.example.lowesweatherapp.util.State

class WeatherSearchViewModel : ViewModel() {

    private val cityQuery = MutableLiveData<String>()
    private val hasNavigatedLd = MutableLiveData<Boolean>()

    val state: LiveData<State<List<HourlyWeather>>> =
        MediatorLiveData<State<List<HourlyWeather>>>().apply {
            addSource(hasNavigatedLd) {
                if (it) {
                    value = State.NoAction
                    hasNavigated = false
                }
            }
            addSource(cityQuery) {
                addSource(WeatherRepo.getWeatherResponse(it).asLiveData()) { state ->
                    value = state
                }
            }
        }

    var query: String = ""
        set(value) {
            cityQuery.value = value
            field = value
        }

    var hasNavigated: Boolean = false
        set(value) {
            hasNavigatedLd.value = value
            field = value
        }

}