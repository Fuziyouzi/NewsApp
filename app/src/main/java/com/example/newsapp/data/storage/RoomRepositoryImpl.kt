package com.example.newsapp.data.storage

import android.database.sqlite.SQLiteException
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


    override suspend fun createUser(createUser: CreateUser) = handleStorageRequest(dispatcher.io) {
        if (settings.getCurrentUserId() == AppSettings.NO_USER_ID) {
            val entity = UserNewsDbEntity.createUser(createUser)
            userDao.createUser(entity)
            settings.setUserId(0L)
        }
    }

    override suspend fun getUserCountry() = userDao.getUserCountry().country

    override suspend fun updateUserCountry(country: String) {
        userDao.updateUserCountry(
            UserTuple(settings.getCurrentUserId(), country)
        )
    }
}