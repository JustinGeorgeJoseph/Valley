package com.justin.valley.models.common

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoverAsset(
    @Json(name = "url")
    val url: String?,
)
