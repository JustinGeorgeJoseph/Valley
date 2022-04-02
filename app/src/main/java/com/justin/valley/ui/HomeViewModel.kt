package com.justin.valley.ui

import androidx.lifecycle.ViewModel
import com.justin.valley.domain.usecase.HomeContentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeContentsUseCase: HomeContentsUseCase,
) : ViewModel() {

    suspend fun refreshHomeContents() = supervisorScope {
        withContext(Dispatchers.IO) {
            try {
                homeContentsUseCase.refreshHomeNewEpisodes()
            } catch (e: Exception) {

            }
        }
        withContext(Dispatchers.IO) {
            try {
                homeContentsUseCase.refreshHomeChannels()
            } catch (e: Exception) {

            }
        }
        withContext(Dispatchers.IO) {
            try {
                homeContentsUseCase.refreshHomeCategories()
            } catch (e: Exception) {

            }
        }
    }


    //suspend fun getContents() = homeContentsUseCase.getCategories()
    //suspend fun getContents() = homeContentsUseCase.getNewEpisodes()
    suspend fun getContents() = homeContentsUseCase.getChannels()

}