package com.januscole.kotlinscratchpad.di

import com.januscole.kotlinscratchpad.data.source.images.repository.RetrofitRepository
import com.januscole.kotlinscratchpad.data.source.images.repository.RetrofitRepositoryImpl
import com.januscole.kotlinscratchpad.data.source.images.service.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRetrofitRepository(
        retrofitService: RetrofitService
    ): RetrofitRepository {
        return RetrofitRepositoryImpl(retrofitService)
    }
}