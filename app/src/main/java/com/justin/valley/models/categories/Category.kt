package com.justin.valley.models.categories

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class Category(
    @PrimaryKey
    @Json(name = "name")
    @ColumnInfo(name = "name")
    val name: String,
)
