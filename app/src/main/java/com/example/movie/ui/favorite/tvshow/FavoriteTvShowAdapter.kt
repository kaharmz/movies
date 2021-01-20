package com.example.movie.ui.favorite.tvshow

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.BuildConfig
import com.example.movie.data.source.local.entity.TvShow
import com.example.movie.databinding.ItemsTvShowBinding
import com.example.movie.ui.detail.DetailMovieActivity
import com.example.movie.utils.loadImage

class FavoriteTvShowAdapter :
    PagedListAdapter<TvShow, FavoriteTvShowAdapter.FavoriteTvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShow>() {
            override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvShowViewHolder {
        val itemsTvShowBinding =
            ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) holder.bind(tvShow)
    }

    fun getSwipeData(swipedPosition: Int): TvShow? = getItem(swipedPosition)

    class FavoriteTvShowViewHolder(private val binding: ItemsTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            with(binding) {
                tvItemTitle.text = tvShow.name
                tvItemUserScore.text = tvShow.voteAverage.toString()
                imgTvShow.loadImage(BuildConfig.BASE_BACKGROUND_URL + tvShow.backdropPath)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java).apply {
                        putExtra(DetailMovieActivity.EXTRA_MOVIE, tvShow.id)
                        putExtra(DetailMovieActivity.EXTRA_TYPE, DetailMovieActivity.TYPE_TV)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}