package com.justin.valley.di

import android.content.Context
import androidx.room.Room
import com.justin.valley.database.ValleyDatabase
import com.justin.valley.models.channels.Series
import com.justin.valley.models.typeConverters.*
import com.justin.valley.utils.VALLEY_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun providesValleyDatabase(@ApplicationContext applicationContext: Context): ValleyDatabase {
        return Room.databaseBuilder(
            applicationContext,
            ValleyDatabase::class.java, VALLEY_DB
        ).addTypeConverter(CoverAssetTypeConverter())
            .addTypeConverter(NewEpisodeChannelTypeConverter())
            .addTypeConverter(IconAssetTypeConverter())
            .addTypeConverter(SeriesTypeConverter())
            .addTypeConverter(LatestMediaTypeConverter())
            .build()
    }
}