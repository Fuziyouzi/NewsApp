package com.example.newsapp.di

import com.example.newsapp.core.Dispatcher
import com.example.newsapp.data.cloud.CloudRepository
import com.example.newsapp.data.cloud.HandelDataRequest
import com.example.newsapp.data.cloud.HandleDataRequestImpl
import com.example.newsapp.data.cloud.NewsService
import com.example.newsapp.data.core.ErrorDataHandler
import com.example.newsapp.data.core.ErrorDataHandlerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CloudModule {

    private const val BASE_URL = "https://newsapi.org/v2/"

    @Singleton
    @Provides
    fun providesHttpInterceptor() = HttpLoggingInterceptor()
        .apply { level = HttpLoggingInterceptor.Level.BODY }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLogin: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLogin)
            .build()

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): NewsService =
        retrofit.create(NewsService::class.java)


    @Provides
    @Singleton
    fun bindsErrorDataHandler(errorDataHandlerImpl: ErrorDataHandlerImpl): ErrorDataHandler =
        errorDataHandlerImpl

    @Provides
    fun providesDispatcher(): Dispatcher = Dispatcher()

    @Provides
    @Singleton
    fun providesHandleDataRequest(
        errorDataHandler: ErrorDataHandler,
        dispatcher: Dispatcher
    ): HandelDataRequest = HandleDataRequestImpl(errorDataHandler, dispatcher)


    @Provides
    @Singleton
    fun providesRepository(
        newsService: NewsService,
        handelDataRequest: HandelDataRequest
    ) = CloudRepository(newsService, handelDataRequest)


}