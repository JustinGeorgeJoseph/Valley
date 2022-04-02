package com.justin.valley.di

import com.justin.valley.domain.usecase.HomeContentsUseCase
import com.justin.valley.domain.usecase.HomeContentsUseCaseImpl
import com.justin.valley.domain.repo.HomeRepository
import com.justin.valley.repository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class HomeModule {

    @Binds
    abstract fun bindHomeContentsUseCase(
        homeContentsUseCaseImpl: HomeContentsUseCaseImpl
    ): HomeContentsUseCase

    @Binds
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository
}