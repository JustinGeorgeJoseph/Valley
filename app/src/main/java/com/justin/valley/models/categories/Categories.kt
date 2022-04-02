package com.justin.valley.models.categories

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Categories(
    @Json(name = "categories")
    val data : List<Category>
)