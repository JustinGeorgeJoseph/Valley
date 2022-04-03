package com.justin.valley.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.justin.valley.databinding.ItemNewEpisodeBinding
import com.justin.valley.models.newepisodes.Media

class NewEpisodesAdapter : ListAdapter<Media,NewEpisodesAdapter.NewEpisodesViewHolder>(NewEpisodesDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewEpisodesViewHolder {
        return NewEpisodesViewHolder(ItemNewEpisodeBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: NewEpisodesViewHolder, position: Int) {
            holder.bind(getItem(position))
    }

    class NewEpisodesViewHolder(private val binding: ItemNewEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(media: Media) {
            binding.apply {
                title = media.title
                subtitle = media.channel?.title
                url = media.coverAsset?.url
            }
        }
    }
}

class NewEpisodesDiffUtils : DiffUtil.ItemCallback<Media>()  {
    override fun areItemsTheSame(oldItem: Media, newItem: Media): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Media, newItem: Media): Boolean {
        return oldItem.title == newItem.title
    }

}
