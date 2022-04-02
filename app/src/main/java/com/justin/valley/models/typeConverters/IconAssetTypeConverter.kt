package com.justin.valley.models.typeConverters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.justin.valley.models.channels.IconAsset
import com.justin.valley.models.common.CoverAsset

@ProvidedTypeConverter
class IconAssetTypeConverter {
    @TypeConverter
    fun toIconAsset(url: String?): IconAsset {
        return IconAsset(url)
    }

    @TypeConverter
    fun fromIconAsset(iconAsset: IconAsset?): String? {
        return iconAsset?.thumbnailUrl
    }
}