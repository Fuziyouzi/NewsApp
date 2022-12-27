package com.example.newsapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapp.data.storage.UserDao
import com.example.newsapp.data.storage.UserNewsDbEntity

@Database(
    version = 1,
    entities = [
        UserNewsDbEntity::class
    ]
)
abstract class AppDataBase: RoomDatabase() {

    abstract fun getUserDao(): UserDao
}