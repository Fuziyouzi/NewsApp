package com.example.newsapp.data.cloud

import com.example.newsapp.data.models.NewsApiResponce
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("apiKey") key: String,
        @Query("country") country: String
    ): NewsApiResponce

    @GET("top-headlines")
    suspend fun getNewsByCountry(
        @Query("apiKey") key: String,
        @Query("country") country: String
    ): NewsApiResponce

    @GET("top-headlines")
    suspend fun getNewsByTopics(
        @Query("apiKey") key: String,
        @Query("country") country: String,
        @Query("category") topic: String
    ): NewsApiResponce

}