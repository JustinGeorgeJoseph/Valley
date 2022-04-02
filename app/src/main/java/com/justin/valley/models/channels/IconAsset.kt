package com.justin.valley.models.channels

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IconAsset(
    @Json(name = "thumbnailUrl")
    val thumbnailUrl: String?,
)
