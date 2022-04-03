package com.justin.valley.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.justin.valley.databinding.ItemNewEpisodeBinding
import com.justin.valley.models.channels.Channel
import com.justin.valley.models.channels.LatestMedia
import com.justin.valley.models.newepisodes.Media

class CoursesAdapter : ListAdapter<LatestMedia,CoursesAdapter.CoursesViewHolder>(CoursesDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        return CoursesViewHolder(ItemNewEpisodeBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
            holder.bind(getItem(position))
    }

    class CoursesViewHolder(private val binding: ItemNewEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(media: LatestMedia) {
            binding.apply {
                title = media.title
                url = media.coverAsset?.url
            }
        }
    }
}

class CoursesDiffUtils : DiffUtil.ItemCallback<LatestMedia>()  {
    override fun areItemsTheSame(oldItem: LatestMedia, newItem: LatestMedia): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: LatestMedia, newItem: LatestMedia): Boolean {
        return oldItem.title == newItem.title
    }

}
