package com.example.lowesweatherapp.repo.remote

import com.example.lowesweatherapp.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast")
    suspend fun getWeatherForCityResponse(
        @Query("q") city: String,
        @Query("appid") appid: String = "65d00499677e59496ca2f318eb68c049",
        @Query("units") units: String = "imperial"
    ): Response<WeatherResponse>
}