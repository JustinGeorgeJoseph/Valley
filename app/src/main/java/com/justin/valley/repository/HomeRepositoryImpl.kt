package com.justin.valley.repository

import android.util.Log
import com.justin.valley.utils.TAG_LOG
import retrofit2.Retrofit
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val retrofit: Retrofit) : HomeRepository {
    private val calls : ApiCalls by lazy {
         retrofit.create(ApiCalls::class.java)
    }
    override suspend fun getNewEpisodes() {
        val response = calls.getNewEpisodes()
        Log.d(TAG_LOG,response.toString())
    }

    override suspend fun getChannels() {
            val response = calls.getChannels()
            Log.d(TAG_LOG,response.toString())
    }

    override suspend fun getCategories() {

        val response = calls.getCategories()
        Log.d(TAG_LOG,response.toString())
    }
}