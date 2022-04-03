package com.justin.valley.domain.usecase

import com.justin.valley.models.categories.Category
import com.justin.valley.models.channels.Channel
import com.justin.valley.models.newepisodes.Media
import kotlinx.coroutines.flow.Flow

interface HomeContentsUseCase {
    suspend fun refreshHomeNewEpisodes()
    suspend fun refreshHomeChannels()
    suspend fun refreshHomeCategories()

    suspend fun deleteHomeNewEpisodes()
    suspend fun deleteHomeChannels()
    suspend fun deleteHomeCategories()

    suspend fun getCategories() : Flow<List<Category>>
    suspend fun getNewEpisodes() : Flow<List<Media>>
    suspend fun getChannels() : Flow<List<Channel>>
}