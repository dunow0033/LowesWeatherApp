package com.example.lowesweatherapp.util

sealed class State<out R> {

    data class Success<T>(val data: T) : State<T>()
    data class Error(val errMsg: String) : State<Nothing>()
    object Loading : State<Nothing>()
    object NoAction : State<Nothing>()
}