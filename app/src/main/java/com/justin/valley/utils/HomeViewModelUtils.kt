package com.justin.valley.utils

import com.justin.valley.models.channels.Channel


fun <T> getSublist(list: List<T>, max: Int): List<T> {
    return if (list.size > max) {
        list.subList(0, max)
    } else {
        list
    }
}


fun  getSeriesSublist(channel : Channel, max: Int): Channel {
       return channel.apply {
            series = getSublist(this.series ?: emptyList(),max)
        }
}

fun  getCourseSublist(channel : Channel, max: Int): Channel {
    return channel.apply {
        latestMedia = getSublist(this.latestMedia ?: emptyList(),max)
    }
}