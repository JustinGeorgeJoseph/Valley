package com.justin.valley.domain.repo


import com.justin.valley.models.categories.Category
import com.justin.valley.models.channels.Channel
import com.justin.valley.models.newepisodes.Media

interface HomeRepository {
    suspend fun getNewEpisodes() : List<Media>?
    suspend fun getChannels() : List<Channel>?
    suspend fun getCategories() :List<Category>?
}