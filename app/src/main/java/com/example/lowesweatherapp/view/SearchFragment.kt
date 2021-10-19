package com.example.lowesweatherapp.view

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lowesweatherapp.R
import com.example.lowesweatherapp.databinding.FragmentLookupBinding
import com.example.lowesweatherapp.model.HourlyWeather
import com.example.lowesweatherapp.util.State
import com.example.lowesweatherapp.viewmodel.WeatherSearchViewModel

class SearchFragment : Fragment(R.layout.fragment_lookup) {

    private val viewModel: WeatherSearchViewModel by viewModels()
    private lateinit var binding: FragmentLookupBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLookupBinding.bind(view).apply {
            btnSearch.setOnClickListener { viewModel.query = etCity.text.toString() }
        }
        with(viewModel) {
            state.observe(viewLifecycleOwner) {
                if (it is State.Success) navigateToWeatherList(query, it.data.toTypedArray())
                with(binding.textFieldLayout) {
                    isErrorEnabled = if (it is State.Error) {
                        error = it.errMsg;true
                    } else false
                }
                binding.progressBar.isVisible = it is State.Loading
                binding.btnSearch.isEnabled = it !is State.Loading
            }
        }
    }

    private fun navigateToWeatherList(
        city: String, data: Array<HourlyWeather>
    ) {
        findNavController().navigate(
            SearchFragmentDirections.actionSearchFragmentToHourlyWeatherFragment(
                data,
                city
            )
        )
        viewModel.hasNavigated = true
    }
}
