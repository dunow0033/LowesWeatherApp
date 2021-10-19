package com.example.lowesweatherapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lowesweatherapp.R
import com.example.lowesweatherapp.adapter.WeatherAdapter
import com.example.lowesweatherapp.databinding.FragmentHourlyWeatherBinding
import com.example.lowesweatherapp.model.HourlyWeather
import com.example.lowesweatherapp.util.init

class HourlyWeatherFragment : Fragment(R.layout.fragment_hourly_weather) {

    private val arguments: HourlyWeatherFragmentArgs by navArgs()

    private val weatherAdapter by lazy {
        WeatherAdapter(arguments.myWeather.toList(), this::onWeatherSelected)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(FragmentHourlyWeatherBinding.bind(view)) {
            toolbar.init(arguments.city)
            rvWeather.adapter = weatherAdapter
        }
    }

    private fun onWeatherSelected(weather: HourlyWeather) {
        findNavController().navigate(
            HourlyWeatherFragmentDirections.actionHourlyWeatherFragmentToWeatherInfoFragment(
                weather, arguments.city
            )
        )
    }
}
