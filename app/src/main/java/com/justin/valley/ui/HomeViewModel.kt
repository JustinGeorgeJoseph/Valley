package com.justin.valley.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.justin.valley.domain.HomeContentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeContentsUseCase: HomeContentsUseCase,
) : ViewModel() {

    suspend fun getHomeContents() = supervisorScope {
        withContext(Dispatchers.IO) {
            try {
                homeContentsUseCase.getHomeNewEpisodes()
            } catch (e: Exception) {

            }
        }
        withContext(Dispatchers.IO) {
            try {
                homeContentsUseCase.getHomeChannels()
            } catch (e: Exception) {

            }
        }
        withContext(Dispatchers.IO) {
            try {
                homeContentsUseCase.getHomeCategories()
            } catch (e: Exception) {

            }
        }
    }

}