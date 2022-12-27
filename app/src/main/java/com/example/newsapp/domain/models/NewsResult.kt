package com.example.newsapp.domain.models


sealed class NewsResult<out S, out E> {

    data class Success<out T>(val value: T) : NewsResult<T, Nothing>()

    data class Failure<out F>(val error: String) : NewsResult<Nothing, F>()


}



