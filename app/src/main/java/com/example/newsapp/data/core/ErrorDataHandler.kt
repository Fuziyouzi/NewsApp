package com.example.newsapp.data.core

import com.example.newsapp.domain.models.DomainError

interface ErrorDataHandler {

    fun handle(e: Exception): DomainError
}