package com.example.newsapp.domain

import com.example.newsapp.data.storage.CreateUser

interface RoomRepository {

    suspend fun getUserCountry(): String

    suspend fun updateUserCountry(country: String)

    suspend fun isAlreadyExist(): Boolean
}