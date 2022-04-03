package com.justin.valley.domain.usecase

import com.justin.valley.database.ValleyDatabase
import com.justin.valley.domain.repo.HomeRepository
import com.justin.valley.models.categories.Category
import com.justin.valley.models.channels.Channel
import com.justin.valley.models.newepisodes.Media
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeContentsUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository,
    private val valleyDatabase: ValleyDatabase,
) : HomeContentsUseCase {

    override suspend fun refreshHomeNewEpisodes() {
        try {
            homeRepository.getNewEpisodes()?.forEach {
                valleyDatabase.getNewEpisodesDao().insertNewEpisodes(it)
            }
        } catch (e: Exception) {
        }
    }

    override suspend fun refreshHomeChannels() {
        try {
            homeRepository.getChannels()?.forEach {
                valleyDatabase.getChannelsDao().insertChannels(it)
            }
        } catch (e: Exception) {
        }
    }

    override suspend fun refreshHomeCategories() {
        try {
            homeRepository.getCategories()?.forEach { category ->
                valleyDatabase.getCategoryDao().insertCategory(category)
            }
        } catch (e: Exception) {
        }
    }

    override suspend fun getCategories(): Flow<List<Category>> =
        valleyDatabase.getCategoryDao().getCategories()

    override suspend fun getNewEpisodes(): Flow<List<Media>> =
        valleyDatabase.getNewEpisodesDao().getNewEpisodes()

    override suspend fun getChannels(): Flow<List<Channel>> =
        valleyDatabase.getChannelsDao().getChannels()

}