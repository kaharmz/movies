package com.example.movie.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.movie.BuildConfig
import com.example.movie.R
import com.example.movie.data.Movie
import com.example.movie.data.TvShow
import com.example.movie.databinding.ActivityDetailMovieBinding
import com.example.movie.databinding.DetailContentMovieBinding
import com.example.movie.ui.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity(), DetailActivityCallback {

    companion object {

        const val EXTRA_MOVIE = "extra_movie"

        const val EXTRA_TYPE = "extra_type"

        const val TYPE_MOVIE = "type_movie"

        const val TYPE_TV = "type_tv"

    }

    private lateinit var detailContentMovieBinding: DetailContentMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)

        detailContentMovieBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance()

        val viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val id = intent.getIntExtra(EXTRA_MOVIE, 0)

        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {

            activityDetailMovieBinding.progressBar.visibility = View.VISIBLE

            activityDetailMovieBinding.scrollView.visibility = View.INVISIBLE

            viewModel.getDetailMovie(id).observe(this, { movie ->

                activityDetailMovieBinding.progressBar.visibility = View.GONE

                activityDetailMovieBinding.scrollView.visibility = View.VISIBLE

                bindToMovie(movie)
            })
        } else if (type.equals(TYPE_TV, ignoreCase = true)) {

            activityDetailMovieBinding.progressBar.visibility = View.VISIBLE

            activityDetailMovieBinding.scrollView.visibility = View.INVISIBLE

            viewModel.getDetailTvShow(id).observe(this, { tvShow ->

                activityDetailMovieBinding.progressBar.visibility = View.GONE

                activityDetailMovieBinding.scrollView.visibility = View.VISIBLE

                bindToTvShow(tvShow)
            })
        }
    }

    @SuppressLint("DefaultLocale")
    private fun bindToMovie(movies: Movie) {

        detailContentMovieBinding.textTitle.text = movies.title

        detailContentMovieBinding.textRelease.text = movies.releaseDate

        detailContentMovieBinding.textLanguage.text = movies.originalLanguage

        detailContentMovieBinding.textVoteAverage.text = movies.voteAverage.toString()

        detailContentMovieBinding.textVoteCount.text = movies.voteCount.toString()

        detailContentMovieBinding.textPopularity.text = movies.popularity.toString()

        detailContentMovieBinding.textOverview.text = movies.overview

        detailContentMovieBinding.btnShare.setOnClickListener { onShareClick() }

        getImageMovie(movies)
    }

    private fun getImageMovie(movies: Movie) {
        Glide.with(this)

                .load(BuildConfig.BASE_BACKGROUND_URL + movies.backdropPath)

                .transform(RoundedCorners(10))

                .centerCrop()

                .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_image_search)

                                .error(R.drawable.ic_broken_image_gray)
                )

                .into(detailContentMovieBinding.imagePoster)
    }

    @SuppressLint("DefaultLocale")
    private fun bindToTvShow(tvShow: TvShow) {

        detailContentMovieBinding.textTitle.text = tvShow.name

        detailContentMovieBinding.textRelease.text = tvShow.firstAirDate

        detailContentMovieBinding.textLanguage.text = tvShow.originalLanguage

        detailContentMovieBinding.textVoteAverage.text = tvShow.voteAverage.toString()

        detailContentMovieBinding.textVoteCount.text = tvShow.voteCount.toString()

        detailContentMovieBinding.textPopularity.text = tvShow.popularity.toString()

        detailContentMovieBinding.textOverview.text = tvShow.overview

        detailContentMovieBinding.btnShare.setOnClickListener { onShareClick() }

        getImageMovie(tvShow)
    }

    private fun getImageMovie(tvShow: TvShow) {
        Glide.with(this)

                .load(BuildConfig.BASE_BACKGROUND_URL + tvShow.backdropPath)

                .transform(RoundedCorners(10))

                .centerCrop()

                .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_image_search)

                                .error(R.drawable.ic_broken_image_gray)
                )

                .into(detailContentMovieBinding.imagePoster)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {

            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onShareClick() {

        val sendIntent: Intent = Intent().apply {

            action = Intent.ACTION_SEND

            putExtra(Intent.EXTRA_TEXT, BuildConfig.SHARE_URL)

            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)

        startActivity(shareIntent)
    }

}