package com.example.newsapp.presenter.base

import com.example.newsapp.domain.models.NewsResult

interface Maper<T, S> {

    fun map(source: S): T

    interface Unit<S>: Maper<kotlin.Unit, S>
}