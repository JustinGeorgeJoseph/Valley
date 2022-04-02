package com.justin.valley.models.typeConverters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.justin.valley.models.newepisodes.NewEpisodeChannel

@ProvidedTypeConverter
class NewEpisodeChannelTypeConverter {
    @TypeConverter
    fun toNewEpisodeChannel(url: String?): NewEpisodeChannel {
        return NewEpisodeChannel(url)
    }

    @TypeConverter
    fun fromNewEpisodeChannel(channel: NewEpisodeChannel?): String? {
        return channel?.title
    }
}