package com.justin.valley.models.newepisodes

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.justin.valley.models.common.CoverAsset
import com.justin.valley.models.typeConverters.CoverAssetTypeConverter
import com.justin.valley.models.typeConverters.NewEpisodeChannelTypeConverter
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class Media(
    @Json(name = "type")
    val type: String?,

    @Json(name = "title")
    val title: String?,

    @Json(name = "coverAsset")
    @TypeConverters(CoverAssetTypeConverter::class)
    val coverAsset: CoverAsset?,

    @Json(name = "channel")
    @TypeConverters(NewEpisodeChannelTypeConverter::class)
    val channel: NewEpisodeChannel?,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
