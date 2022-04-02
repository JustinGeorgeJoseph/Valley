package com.justin.valley.domain

interface HomeContentsUseCase {
    suspend fun getHomeNewEpisodes()
    suspend fun getHomeChannels()
    suspend fun getHomeCategories()
}