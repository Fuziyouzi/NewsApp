package com.example.newsapp.data.storage

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsapp.domain.models.UserNews


@Entity(
    tableName = "user"
)
data class UserNewsDbEntity(
   @PrimaryKey(autoGenerate = true) val id: Long,
    val country: String
){

    fun toUser(): UserNews = UserNews(country = country)

    companion object{
        fun createUser(createUser: CreateUser): UserNewsDbEntity = UserNewsDbEntity(
            id = 0,
            country = createUser.country
        )
    }
}