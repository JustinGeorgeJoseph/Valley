package com.justin.valley.adapters

import com.justin.valley.models.categories.Category
import com.justin.valley.models.channels.LatestMedia
import com.justin.valley.models.channels.Series
import com.justin.valley.models.newepisodes.Media

sealed class HomeRowType{
    class NewEpisodeRow(val episodes : List<Media>) : HomeRowType()
    class CourseRow(val courses : List<LatestMedia>) : HomeRowType()
    class SeriesRow(val series : List<Series>) : HomeRowType()
    class CategoryRow(val categories : List<Category>) : HomeRowType()
}
