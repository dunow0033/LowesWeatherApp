package com.example.lowesweatherapp.util

import androidx.navigation.findNavController
import com.google.android.material.appbar.MaterialToolbar

fun MaterialToolbar.init(titleString: String) {
    title = titleString
    setNavigationOnClickListener { findNavController().navigateUp() }
}