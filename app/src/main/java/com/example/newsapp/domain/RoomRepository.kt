package com.example.newsapp.domain

import com.example.newsapp.data.storage.CreateUser

interface RoomRepository {

    suspend fun createUser(createUser: CreateUser)

    suspend fun getUserCountry(): String

    suspend fun updateUserCountry(country: String)
}