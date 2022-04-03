package com.justin.valley.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.justin.valley.adapters.utils.HomeRowType
import com.justin.valley.domain.usecase.HomeContentsUseCase
import com.justin.valley.utils.HomeRefreshStatus
import com.justin.valley.utils.getCourseSublist
import com.justin.valley.utils.getSeriesSublist
import com.justin.valley.utils.getSublist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeContentsUseCase: HomeContentsUseCase,
) : ViewModel() {

    private val _homeRefreshStatus = MutableLiveData<HomeRefreshStatus>()
    val homeRefreshStatus : LiveData<HomeRefreshStatus> = _homeRefreshStatus

    suspend fun fetchHomeContents() = supervisorScope {
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


    suspend fun getContents() : Flow<List<HomeRowType>> {
            val newEpisodeFlow = homeContentsUseCase.getNewEpisodes()
                .distinctUntilChanged().flowOn(Dispatchers.Default)
            val channelsFlow = homeContentsUseCase.getChannels()
                .distinctUntilChanged().flowOn(Dispatchers.Default)
            val categoriesFlow = homeContentsUseCase.getCategories()
                .distinctUntilChanged().flowOn(Dispatchers.Default)
            val contents =combine(newEpisodeFlow,
                channelsFlow,
                categoriesFlow) { newEpisodes, channels, categories ->
                _homeRefreshStatus.postValue(HomeRefreshStatus.ENDED)
                val homeContent = arrayListOf<HomeRowType>()
                homeContent.add(HomeRowType.NewEpisodeRow(getSublist(newEpisodes,6)))
                channels.forEach { channel ->
                    if (channel.series.isNullOrEmpty()) {
                        homeContent.add(HomeRowType.CourseRow(getCourseSublist(channel,6)))
                    } else {
                        homeContent.add(HomeRowType.SeriesRow(getSeriesSublist(channel,6)))
                    }
                }
                homeContent.add(HomeRowType.CategoryRow(categories))
                homeContent
            }
        return contents
    }

    suspend fun refreshHomeContents() =  supervisorScope {
        try {
            _homeRefreshStatus.postValue(HomeRefreshStatus.STARTED)
            homeContentsUseCase.run {
                deleteHomeNewEpisodes()
                deleteHomeChannels()
                deleteHomeCategories()
            }
            fetchHomeContents()
        }catch (e:Exception){

        }
    }

}