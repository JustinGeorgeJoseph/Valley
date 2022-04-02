package com.justin.valley.models.newepisodes

import com.justin.valley.models.CoverAsset
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Media(
    @Json(name = "type")
    val type: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "coverAsset")
    val coverAsset: CoverAsset?,
    @Json(name = "channel")
    val channel: NewEpisodeChannel?,
)
