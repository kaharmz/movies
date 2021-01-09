package com.example.movie.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movie.BuildConfig
import com.example.movie.R
import com.example.movie.data.Movie
import com.example.movie.databinding.ItemsMovieBinding
import com.example.movie.ui.detail.DetailMovieActivity
import com.example.movie.ui.detail.DetailMovieActivity.Companion.TYPE_MOVIE

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovie = ArrayList<Movie>()

    fun setMovie(movies: List<Movie>?) {

        if (movies == null) return

        this.listMovie.clear()

        this.listMovie.addAll(movies)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val itemsMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movies = listMovie[position]

        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovie.size

    class MovieViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movies: Movie) {

            with(binding) {

                tvItemTitle.text = movies.title

                tvVoteCount.text = movies.voteCount.toString()

                Glide.with(itemView.context)

                        .load(BuildConfig.BASE_POSTER_URL + movies.posterPath)

                        .centerCrop()

                        .apply(RequestOptions.placeholderOf(R.drawable.ic_image_search)

                                .error(R.drawable.ic_broken_image_gray))

                        .into(imgMovie)

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