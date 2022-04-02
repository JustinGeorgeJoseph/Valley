package com.justin.valley.repository

interface HomeRepository {
    suspend fun getNewEpisodes()
    suspend fun getChannels()
    suspend fun getCategories()
}