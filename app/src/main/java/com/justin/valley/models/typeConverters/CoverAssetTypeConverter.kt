package com.justin.valley.models.typeConverters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.justin.valley.models.common.CoverAsset

@ProvidedTypeConverter
class CoverAssetTypeConverter {
    @TypeConverter
    fun toCoverAsset(url: String?): CoverAsset {
        return CoverAsset(url)
    }

    @TypeConverter
    fun fromCoverAsset(coverAsset: CoverAsset?): String? {
        return coverAsset?.url
    }
}