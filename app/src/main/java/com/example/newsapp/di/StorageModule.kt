package com.example.newsapp.di

import com.example.newsapp.data.storage.RoomRepositoryImpl
import com.example.newsapp.domain.RoomRepository
import com.example.newsapp.data.storage.settings.AppSettings
import com.example.newsapp.data.storage.settings.SharedPrefSettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Provides
    @Singleton
    fun provideSharedPref(sharedPrefSettings: SharedPrefSettings): AppSettings{
        return sharedPrefSettings
    }

    @Provides
    @Singleton
    fun providesRoomRepo(roomRepositoryImpl: RoomRepositoryImpl): RoomRepository{
        return roomRepositoryImpl
    }

}