package com.example.newsapp.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Query("SELECT id, country FROM user")
    suspend fun getUserCountry(): UserTuple

    @Update(entity = UserNewsDbEntity::class)
    suspend fun updateUserCountry(userTuple: UserTuple)

    @Insert
    suspend fun createUser(userNewsDbEntity: UserNewsDbEntity)

}