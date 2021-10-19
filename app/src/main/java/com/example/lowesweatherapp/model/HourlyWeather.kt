package com.example.lowesweatherapp.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class HourlyWeather(
    @Json(name = "clouds")
    val clouds: Clouds?,
    @Json(name = "dt")
    val dt: Double?,
    @Json(name = "dt_txt")
    val dtTxt: String?,
    @Json(name = "main")
    val main: Main?,
    @Json(name = "pop")
    val pop: Double?,
    @Json(name = "rain")
    val rain: Rain?,
    @Json(name = "sys")
    val sys: Sys?,
    @Json(name = "visibility")
    val visibility: Double?,
    @Json(name = "weather")
    val weather: List<Weather>?,
    @Json(name = "wind")
    val wind: Wind?
) : Parcelable