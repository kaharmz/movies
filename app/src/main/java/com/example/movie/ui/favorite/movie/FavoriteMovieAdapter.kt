package com.example.movie.ui.favorite.movie

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.BuildConfig
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.databinding.ItemsMovieBinding
import com.example.movie.ui.detail.DetailMovieActivity
import com.example.movie.ui.detail.DetailMovieActivity.Companion.TYPE_MOVIE
import com.example.movie.utils.loadImage

class FavoriteMovieAdapter :
    PagedListAdapter<Movie, FavoriteMovieAdapter.FavoriteMovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder {
        val itemsMovieBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        val favoriteMovie = getItem(position)
        if (favoriteMovie != null) holder.bind(favoriteMovie)
    }

    fun getSwipedData(swipePosition: Int): Movie? = getItem(swipePosition)

    class FavoriteMovieViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvVoteCount.text = movie.voteCount.toString()
                imgMovie.loadImage(BuildConfig.BASE_POSTER_URL + movie.posterPath)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java).apply {
                        putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.id)
                        putExtra(DetailMovieActivity.EXTRA_TYPE, TYPE_MOVIE)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}