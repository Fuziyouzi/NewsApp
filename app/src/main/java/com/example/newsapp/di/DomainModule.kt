package com.example.newsapp.di

import com.example.newsapp.core.ManageResources
import com.example.newsapp.core.ManageResourcesImpl
import com.example.newsapp.data.CloudRepository
import com.example.newsapp.domain.*
import com.example.newsapp.domain.usecases.TopStoriesUseCase
import com.example.newsapp.domain.usecases.TopStoriesUseCaseImpl
import com.example.newsapp.domain.usecases.TopicsUseCase
import com.example.newsapp.domain.usecases.TopicsUseCaseImpl
import com.example.newsapp.presenter.base.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun providesNewsRep(cloudRepository: CloudRepository): NewsRepository

    @Binds
    fun bindsTopicsUseCase(topicsUseCaseImpl: TopicsUseCaseImpl): TopicsUseCase

    @Binds
    fun bindsTopStoriesUseCase(topStoriesUseCaseImpl: TopStoriesUseCaseImpl): TopStoriesUseCase

    @Binds
    fun bindsResourceManager(resourcesImpl: ManageResourcesImpl): ManageResources

    @Binds
    fun bindsHandleError(handleErrorImpl: HandleErrorImpl): HandleError<String>

    @Binds
    fun bindsHandleRequest(handleRequestImpl: HandleRequestImpl): HandleRequest

    @Binds
    fun bindsHandleNewsRequest(handleNewsRequestImpl: HandleNewsRequestImpl): HandleNewsRequest

    @Binds
    fun bindsImageLoader(imageLoaderImpl: ImageLoaderImpl): ImageLoader



}