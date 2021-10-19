package com.example.lowesweatherapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.lowesweatherapp.R
import com.example.lowesweatherapp.databinding.FragmentWeatherInfoBinding
import com.example.lowesweatherapp.util.init

class WeatherInfoFragment : Fragment(R.layout.fragment_weather_info) {

    private val arguments: WeatherInfoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentWeatherInfoBinding.bind(view).apply {
            toolbar.init(arguments.city)
            tvMainTemp.text = arguments.selectedWeather.main?.temp.toString()
            tvFeelsLike.text = arguments.selectedWeather.main?.feelsLike.toString()
            tvMainWeather.text = arguments.selectedWeather.weather?.get(0)?.main
            tvDescription.text = arguments.selectedWeather.weather?.get(0)?.description
        }
    }
}