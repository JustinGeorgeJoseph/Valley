package com.justin.valley.models.typeConverters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.justin.valley.models.channels.Series
import com.justin.valley.models.common.Serieses
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@ProvidedTypeConverter
class SeriesTypeConverter {

    private val jsonAdapter: JsonAdapter<Serieses> = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build().adapter(Serieses::class.java)

    @TypeConverter
    fun toCoverAsset(response: String?): List<Series>? {
        return response?.let { jsonAdapter.fromJson(it)?.series }
    }

    @TypeConverter
    fun fromCoverAsset(list: List<Series>?): String? {
        return jsonAdapter.toJson(Serieses(list))
    }
}