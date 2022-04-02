package com.justin.valley.models.categories

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(
    @Json(name = "name")
    val name: String?,
)
