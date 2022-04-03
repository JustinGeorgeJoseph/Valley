package com.justin.valley.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.justin.valley.R
import com.justin.valley.databinding.*

class HomeAdapter : ListAdapter<HomeRowType, HomeAdapter.HomeViewHolder>(HomeDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return when (viewType) {
            HomeRowTypeEnum.NEWEPISODE.ordinal -> {
                NewEpisodesViewHolder(ItemNewEpisodesBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false))
            }
            HomeRowTypeEnum.COURSE.ordinal -> {
                CoursesViewHolder(ItemChannelBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false))
            }
            HomeRowTypeEnum.SERIES.ordinal -> {
                SeriesViewHolder(ItemChannelBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false))
            }
            HomeRowTypeEnum.CATEGORY.ordinal -> {
                CategoriesViewHolder(ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false))
            }
            else -> {
                EmptyViewHolder(ItemEmptyBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false))
            }
        }
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HomeRowType.CategoryRow -> {
                HomeRowTypeEnum.CATEGORY.ordinal
            }
            is HomeRowType.CourseRow -> {
                HomeRowTypeEnum.COURSE.ordinal
            }
            is HomeRowType.SeriesRow -> {
                HomeRowTypeEnum.SERIES.ordinal
            }
            is HomeRowType.NewEpisodeRow -> {
                HomeRowTypeEnum.NEWEPISODE.ordinal
            }
        }
    }

    abstract class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(rowType: HomeRowType)
    }


    class NewEpisodesViewHolder(private val binding: ItemNewEpisodesBinding) :
        HomeViewHolder(binding.root) {
        override fun bind(rowType: HomeRowType) {
            with(binding) {
                val adapter = NewEpisodesAdapter().apply {
                    submitList((rowType as HomeRowType.NewEpisodeRow).episodes)
                }
                recyNewEpisodes.layoutManager =
                    LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                recyNewEpisodes.adapter = adapter
            }
        }
    }

    class CoursesViewHolder(private val binding: ItemChannelBinding) :
        HomeViewHolder(binding.root) {
        override fun bind(rowType: HomeRowType) {
            with(binding) {
                (rowType as HomeRowType.CourseRow).courses.let {
                    title = it.title
                    iconUrl = it.iconAsset?.thumbnailUrl
                    episodeCount = "${it.mediaCount} ${binding.root.context.resources.getString(
                        R.string.episodes)}"

                    val adapter = CoursesAdapter().apply {
                        submitList(it.latestMedia)
                    }
                    recyCourses.layoutManager =
                        LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                    recyCourses.adapter = adapter
                }
            }

        }
    }

    class SeriesViewHolder(private val binding: ItemChannelBinding) :
        HomeViewHolder(binding.root) {
        override fun bind(rowType: HomeRowType) {
            with(binding) {
                (rowType as HomeRowType.SeriesRow).series.let {
                    title = it.title
                    iconUrl = it.iconAsset?.thumbnailUrl
                    episodeCount = "${it.mediaCount} ${binding.root.context.resources.getString(
                        R.string.episodes)}"

                    val adapter = SeriesAdapter().apply {
                        submitList(it.series)
                    }
                    recyCourses.layoutManager =
                        LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                    recyCourses.adapter = adapter
                }
            }
        }
    }

    class CategoriesViewHolder(private val binding: ItemCategoriesBinding) :
        HomeViewHolder(binding.root) {
        override fun bind(rowType: HomeRowType) {
            with(binding) {
                val adapter = CategoriesAdapter().apply {
                    submitList((rowType as HomeRowType.CategoryRow).categories)
                }
                recyCategories.layoutManager = GridLayoutManager(binding.root.context,2)
                recyCategories.adapter = adapter
            }
        }
    }

    class EmptyViewHolder(private val binding: ItemEmptyBinding) : HomeViewHolder(binding.root) {
        override fun bind(rowType: HomeRowType) {

        }
    }

}