package com.justin.valley.repository

import android.util.Log
import com.justin.valley.domain.repo.HomeRepository
import com.justin.valley.models.categories.Category
import com.justin.valley.models.channels.Channel
import com.justin.valley.models.newepisodes.Media
import com.justin.valley.utils.TAG_LOG
import retrofit2.Retrofit
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val retrofit: Retrofit) : HomeRepository {
    private val calls : ApiCalls by lazy {
         retrofit.create(ApiCalls::class.java)
    }
    override suspend fun getNewEpisodes(): List<Media>? {
        try{
            val response = calls.getNewEpisodes()
            Log.d(TAG_LOG,response.toString())
            return response.data?.media
        } catch (e: Exception){
            throw e
        }
    }

    override suspend fun getChannels(): List<Channel>? {
        try{
            val response = calls.getChannels()
            Log.d(TAG_LOG,response.toString())
            return response.data?.channels
        } catch (e: Exception){
            throw e
        }
    }
    override suspend fun getCategories(): List<Category>? {
        try{
            val response = calls.getCategories()
            Log.d(TAG_LOG,response.toString())
            return  response.data?.categories
        } catch (e: Exception){
            throw e
        }
    }
}