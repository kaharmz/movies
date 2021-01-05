package com.example.movie.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movie.R
import com.example.movie.data.Movie
import com.example.movie.databinding.ItemsMovieBinding
import com.example.movie.ui.detail.DetailMovieActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovie = ArrayList<Movie>()

    fun setMovie(movies: List<Movie>?) {

        when (movies) {
            null -> return
            else -> {
                this.listMovie.clear()

                this.listMovie.addAll(movies)
            }
        }

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

                tvItemUserScore.text = movies.userScore

                Glide.with(itemView.context)

                        .load(movies.image)

                        .centerCrop()

                        .apply(RequestOptions.placeholderOf(R.drawable.ic_image_search)

                                .error(R.drawable.ic_broken_image_gray))

                        .into(imgMovie)

                itemView.setOnClickListener {

                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)

                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies.id)

                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}