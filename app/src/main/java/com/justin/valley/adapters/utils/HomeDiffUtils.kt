package com.justin.valley.adapters.utils

import androidx.recyclerview.widget.DiffUtil

class HomeDiffUtils : DiffUtil.ItemCallback<HomeRowType>() {
    override fun areItemsTheSame(oldItem: HomeRowType, newItem: HomeRowType): Boolean {
            return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HomeRowType, newItem: HomeRowType): Boolean {
        return oldItem == newItem
    }
}