package com.example.lowesweatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lowesweatherapp.databinding.WeatherItemBinding
import com.example.lowesweatherapp.model.HourlyWeather

class WeatherAdapter(
    private val hourlyWeather: List<HourlyWeather>,
    private val listener: (weather: HourlyWeather) -> Unit
) : RecyclerView.Adapter<WeatherAdapter.HourlyWeatherViewHolder>() {

    inner class HourlyWeatherViewHolder(
        private val binding: WeatherItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun setAllWeather(hourlyWeather: HourlyWeather) = with(binding) {
            tvWeatherMain.text = "${hourlyWeather.weather?.get(0)?.main}"
            tvTemp.text = String.format("Temp: %d", hourlyWeather.main?.temp?.toInt())
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = WeatherItemBinding.inflate(
        LayoutInflater.from(parent.context), parent, false
    ).let {
        HourlyWeatherViewHolder(it).apply {
            itemView.setOnClickListener { listener.invoke(hourlyWeather[adapterPosition]) }
        }
    }

    override fun onBindViewHolder(viewHolder: HourlyWeatherViewHolder, position: Int) {
        viewHolder.setAllWeather(hourlyWeather[position])
    }

    override fun getItemCount() = hourlyWeather.size
}