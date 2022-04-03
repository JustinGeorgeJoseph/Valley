package com.justin.valley.adapters

import androidx.recyclerview.widget.DiffUtil

class HomeDiffUtils : DiffUtil.ItemCallback<HomeRowType>() {
    override fun areItemsTheSame(oldItem: HomeRowType, newItem: HomeRowType): Boolean {
            return false
    }

    override fun areContentsTheSame(oldItem: HomeRowType, newItem: HomeRowType): Boolean {
        return false
    }
}