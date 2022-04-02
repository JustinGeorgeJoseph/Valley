package com.justin.valley.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.justin.valley.models.categories.Category
import com.justin.valley.models.channels.Channel
import com.justin.valley.models.newepisodes.Media
import com.justin.valley.models.typeConverters.*

@Database(entities = [Category::class, Media::class, Channel::class], version = 1)
@TypeConverters(CoverAssetTypeConverter::class,
    NewEpisodeChannelTypeConverter::class,
    IconAssetTypeConverter::class,
    SeriesTypeConverter::class,
    LatestMediaTypeConverter::class)
abstract class ValleyDatabase : RoomDatabase() {
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getNewEpisodesDao(): NewEpisodesDao
    abstract fun getChannelsDao(): ChannelsDao
}