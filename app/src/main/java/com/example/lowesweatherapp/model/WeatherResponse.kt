package com.example.lowesweatherapp.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class WeatherResponse(
    @Json(name = "city")
    val city: City?,
    @Json(name = "cnt")
    val cnt: Double?,
    @Json(name = "cod")
    val cod: String?,
    @Json(name = "list")
    val list: List<HourlyWeather>?,
    @Json(name = "message")
    val message: Double?
) : Parcelable