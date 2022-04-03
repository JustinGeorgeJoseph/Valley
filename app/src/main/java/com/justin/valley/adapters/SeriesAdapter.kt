package com.justin.valley.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.justin.valley.databinding.ItemSeriesBinding
import com.justin.valley.models.channels.Series

class SeriesAdapter : ListAdapter<Series,SeriesAdapter.SeriesViewHolder>(SeriesDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        return SeriesViewHolder(ItemSeriesBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
            holder.bind(getItem(position))
    }

    class SeriesViewHolder(private val binding: ItemSeriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(media: Series) {
            binding.apply {
                title = media.title
                url = media.coverAsset?.url
            }
        }
    }
}

class SeriesDiffUtils : DiffUtil.ItemCallback<Series>()  {
    override fun areItemsTheSame(oldItem: Series, newItem: Series): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Series, newItem: Series): Boolean {
        return oldItem.title == newItem.title
    }

}
