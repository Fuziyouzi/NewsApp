package com.example.newsapp.domain.usecases

import com.example.newsapp.data.cloud.CloudRepository
import com.example.newsapp.data.storage.CreateUser
import com.example.newsapp.domain.HandleRequest
import com.example.newsapp.domain.HandleUserRequest
import com.example.newsapp.domain.RoomRepository
import com.example.newsapp.domain.models.NewsModel
import com.example.newsapp.domain.models.NewsResult
import com.example.newsapp.presenter.base.HandleNewsRequest
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(
    private val storage: RoomRepository,
    private val handleUserRequest: HandleUserRequest,
    private val handleRequest: HandleRequest,
    private val cloud: CloudRepository
) : UserUseCase {


    override suspend fun getUserCountry() = handleUserRequest.handle {
        storage.getUserCountry()
    }

    override suspend fun updateUserCountry(country: String) = handleUserRequest.handleUnit {
        storage.updateUserCountry(country)
    }

    override suspend fun getCountry(): NewsResult<List<NewsModel>, String> = handleRequest.handle {
        cloud.getNewsByCountry(storage.getUserCountry())
    }

}