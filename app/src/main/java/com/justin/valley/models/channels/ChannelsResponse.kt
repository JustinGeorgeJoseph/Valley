package com.justin.valley.models.channels

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChannelsResponse(
    @Json(name = "data")
    val data : Channels?
)