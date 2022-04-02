package com.justin.valley.repository

import com.justin.valley.models.categories.CategoriesResponse
import com.justin.valley.models.channels.ChannelsResponse
import com.justin.valley.models.newepisodes.NewEpisodesResponse
import retrofit2.http.GET

interface ApiCalls {

    @GET("/raw/z5AExTtw")
    suspend fun getNewEpisodes(): NewEpisodesResponse

    @GET("/raw/Xt12uVhM")
    suspend fun getChannels(): ChannelsResponse

    @GET("/raw/A0CgArX3")
    suspend fun getCategories(): CategoriesResponse

}