package com.justin.valley.domain

import android.util.Log
import com.justin.valley.repository.HomeRepository
import com.justin.valley.utils.TAG_LOG
import javax.inject.Inject

class HomeContentsUseCaseImpl @Inject constructor(private val homeRepository: HomeRepository) :
    HomeContentsUseCase {
    override suspend fun getHomeNewEpisodes() {
        homeRepository.getNewEpisodes()
    }

    override suspend fun getHomeChannels() {
        homeRepository.getChannels()
    }

    override suspend fun getHomeCategories() {
        homeRepository.getCategories()
    }
}