package com.example.lowesweatherapp.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class City(
    @Json(name = "coord")
    val coord: Coord?,
    @Json(name = "country")
    val country: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "population")
    val population: Double?,
    @Json(name = "sunrise")
    val sunrise: Double?,
    @Json(name = "sunset")
    val sunset: Double?,
    @Json(name = "timezone")
    val timezone: Double?
) : Parcelable