package com.example.newsapp.data.storage


import com.example.newsapp.core.Dispatcher
import com.example.newsapp.data.core.handleStorageRequest
import com.example.newsapp.data.storage.settings.AppSettings
import com.example.newsapp.domain.RoomRepository
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val dispatcher: Dispatcher,
    private val settings: AppSettings
) : RoomRepository {


    private suspend fun createUser() = handleStorageRequest(dispatcher.io) {
            val entity = UserNewsDbEntity.createUser()
            userDao.createUser(entity)
            settings.setUserId(1L)
    }

    override suspend fun getUserCountry() = handleStorageRequest(dispatcher.io){
        if (isAlreadyExist()){
            userDao.getUserCountry().country
        } else {
            createUser()
            return@handleStorageRequest "Create"
        }
    }

    override suspend fun updateUserCountry(country: String) = handleStorageRequest(dispatcher.io) {
        userDao.updateUserCountry(
            UserTuple(settings.getCurrentUserId(), country)
        )
    }

    override suspend fun isAlreadyExist() = handleStorageRequest(dispatcher.io){
        return@handleStorageRequest settings.getCurrentUserId() != AppSettings.NO_USER_ID
    }
}