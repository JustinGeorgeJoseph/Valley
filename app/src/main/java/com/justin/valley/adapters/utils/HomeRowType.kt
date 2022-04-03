package com.justin.valley.adapters.utils

import com.justin.valley.models.categories.Category
import com.justin.valley.models.channels.Channel
import com.justin.valley.models.newepisodes.Media

sealed class HomeRowType{
    class NewEpisodeRow(val episodes : List<Media>) : HomeRowType()
    class CourseRow(val courses : Channel) : HomeRowType()
    class SeriesRow(val series : Channel) : HomeRowType()
    class CategoryRow(val categories : List<Category>) : HomeRowType()
}


enum class HomeRowTypeEnum {
    NEWEPISODE, COURSE,SERIES,CATEGORY
}