package com.justin.valley.models.typeConverters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.justin.valley.models.channels.LatestMedia
import com.justin.valley.models.common.LatestMedias
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@ProvidedTypeConverter
class LatestMediaTypeConverter {

    private val jsonAdapter: JsonAdapter<LatestMedias> = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build().adapter(LatestMedias::class.java)

    @TypeConverter
    fun toCoverAsset(response: String?): List<LatestMedia>? {
        return response?.let { jsonAdapter.fromJson(it)?.latestMedias }
    }

    @TypeConverter
    fun fromCoverAsset(list: List<LatestMedia>?): String? {
        return jsonAdapter.toJson(LatestMedias(list))
    }
}