package com.justin.valley.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.justin.valley.models.newepisodes.Media
import kotlinx.coroutines.flow.Flow

@Dao
interface NewEpisodesDao {

    @Query("SELECT * FROM Media")
    fun getNewEpisodes(): Flow<List<Media>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNewEpisodes(media: Media)

    @Query("DELETE FROM Media")
    fun deleteAll()
}
