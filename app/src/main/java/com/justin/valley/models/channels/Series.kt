package com.justin.valley.models.channels

import com.justin.valley.models.common.CoverAsset
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Series(
    @Json(name = "title")
    val title: String?,
    @Json(name = "coverAsset")
    val coverAsset: CoverAsset?,
)
