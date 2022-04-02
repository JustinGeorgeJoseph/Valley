package com.justin.valley.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.justin.valley.models.channels.Channel
import kotlinx.coroutines.flow.Flow

@Dao
interface ChannelsDao {

    @Query("SELECT * FROM Channel")
    fun getChannels(): Flow<List<Channel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertChannels(channel: Channel)

    @Query("DELETE FROM Channel")
    fun deleteAll()
}
