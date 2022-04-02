package com.justin.valley.models.common

import com.justin.valley.models.channels.LatestMedia
import com.justin.valley.models.channels.Series

data class Serieses(
    val series: List<Series>?,
)

data class LatestMedias(
    val latestMedias: List<LatestMedia>?,
)
