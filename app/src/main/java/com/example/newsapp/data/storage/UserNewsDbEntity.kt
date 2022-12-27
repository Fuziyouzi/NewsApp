package com.example.newsapp.data.storage

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.newsapp.domain.models.NewsModel
import com.example.newsapp.domain.models.UserNews
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Entity(
    tableName = "user"
)
data class UserNewsDbEntity(
   @PrimaryKey(autoGenerate = true) val id: Long,
    val country: String

){

    companion object{
        fun createUser(): UserNewsDbEntity = UserNewsDbEntity(
            id = 0,
            country = "no_country"
        )
    }
}
