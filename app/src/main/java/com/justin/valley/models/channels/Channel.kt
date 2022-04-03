package com.justin.valley.models.channels

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.justin.valley.models.common.CoverAsset
import com.justin.valley.models.typeConverters.CoverAssetTypeConverter
import com.justin.valley.models.typeConverters.IconAssetTypeConverter
import com.justin.valley.models.typeConverters.LatestMediaTypeConverter
import com.justin.valley.models.typeConverters.SeriesTypeConverter
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class Channel(

    @Json(name = "id")
    var id: String?,

    @Json(name = "title")
    @PrimaryKey
    val title: String,

    @Json(name = "mediaCount")
    var mediaCount: Int = 0,

    @Json(name = "series")
    @TypeConverters(SeriesTypeConverter::class)
    var series: List<Series>?,

    @Json(name = "latestMedia")
    @TypeConverters(LatestMediaTypeConverter::class)
    var latestMedia: List<LatestMedia>?,

    @Json(name = "iconAsset")
    @TypeConverters(IconAssetTypeConverter::class)
    val iconAsset: IconAsset?,

    @Json(name = "coverAsset")
    @TypeConverters(CoverAssetTypeConverter::class)
    val coverAsset: CoverAsset?,

    )
