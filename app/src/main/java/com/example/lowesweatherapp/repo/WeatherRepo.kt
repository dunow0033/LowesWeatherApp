package com.example.lowesweatherapp.repo

import com.example.lowesweatherapp.repo.remote.RetrofitInstance
import com.example.lowesweatherapp.util.State
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object WeatherRepo {

    fun getWeatherResponse(city: String) = flow {
        emit(State.Loading)
        val state = try {
            val response = RetrofitInstance.weatherService.getWeatherForCityResponse(city)
            if (response.validResponse && response.body()?.list.isNullOrEmpty().not())
                State.Success(response.body()!!.list!!)
            else State.Error("No results found for $city")
        } catch (ex: Exception) {
            State.Error("Something went wrong.")
        }
        emit(state)
    }

    private val <T>Response<T>.validResponse
        get() = isSuccessful && body() != null
}