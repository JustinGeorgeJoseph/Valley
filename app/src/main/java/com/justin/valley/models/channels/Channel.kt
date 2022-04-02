package com.justin.valley.models.channels

import com.justin.valley.models.CoverAsset
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Channel(

    @Json(name = "id")
    var id: String?,

    @Json(name = "title")
    val title: String?,

    @Json(name = "mediaCount")
    var type: Int = 0,

    @Json(name = "series")
    val series: List<Series>?,

    @Json(name = "latestMedia")
    val latestMedia: List<LatestMedia>?,

    @Json(name = "iconAsset")
    val iconAsset: IconAsset?,
    
    @Json(name = "coverAsset")
    val coverAsset: CoverAsset?,

    )
