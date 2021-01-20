package com.example.movie.ui.movies

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

class MovieAdapter : PagedListAdapter<Movie, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null) holder.bind(movies)
    }

    class MovieViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: Movie) {
            with(binding) {
                tvItemTitle.text = movies.title
                tvVoteCount.text = movies.voteCount.toString()
                imgMovie.loadImage(BuildConfig.BASE_BACKGROUND_URL + movies.posterPath)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java).apply {
                        putExtra(DetailMovieActivity.EXTRA_MOVIE, movies.id)
                        putExtra(DetailMovieActivity.EXTRA_TYPE, TYPE_MOVIE)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}