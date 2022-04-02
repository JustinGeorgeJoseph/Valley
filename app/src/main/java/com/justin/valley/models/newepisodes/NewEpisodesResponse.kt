package com.justin.valley.models.newepisodes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewEpisodesResponse(
    @Json(name = "data")
    val data : Medias?
)