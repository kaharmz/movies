package com.example.movie.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.movie.R
import com.example.movie.data.Movie
import com.example.movie.data.TvShow
import com.example.movie.databinding.ActivityDetailMovieBinding
import com.example.movie.databinding.DetailContentMovieBinding

class DetailMovieActivity : AppCompatActivity(), DetailActivityCallback {

    companion object {

        const val EXTRA_MOVIE = "extra_movie"

        const val EXTRA_TV = "extra_tv"
    }

    private lateinit var detailContentMovieBinding: DetailContentMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)

        detailContentMovieBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]

        val extras = intent.extras ?: return

        val idMovie = extras.getString(EXTRA_MOVIE)

        val idTv = extras.getString(EXTRA_TV)

        when {
            idMovie != null -> {

                viewModel.setSelectedMovie(idMovie)

                bindToMovie(viewModel.getMovie())

            }
            idTv != null -> {

                viewModel.setSelectedMovie(idTv)

                bindToTv(viewModel.getTvShow())
            }
        }
    }

    private fun bindToMovie(movies: Movie?) {

        detailContentMovieBinding.textTitle.text = movies?.title

        detailContentMovieBinding.textSubtitle.text = movies?.subTitle

        detailContentMovieBinding.textDate.text = movies?.dateRelease

        detailContentMovieBinding.textGenre.text = movies?.genre

        detailContentMovieBinding.textCast.text = movies?.actrees

        detailContentMovieBinding.textOverview.text = movies?.overview

        detailContentMovieBinding.btnShare.setOnClickListener { onShareClick() }

        Glide.with(this)

                .load(movies?.image)

                .transform(RoundedCorners(10))

                .centerCrop()

                .apply(RequestOptions.placeholderOf(R.drawable.ic_image_search)

                        .error(R.drawable.ic_broken_image_gray))

                .into(detailContentMovieBinding.imagePoster)
    }

    private fun bindToTv(tv: TvShow?) {

        detailContentMovieBinding.textTitle.text = tv?.title

        detailContentMovieBinding.textSubtitle.text = tv?.subTitle

        detailContentMovieBinding.textDate.text = tv?.dateRelease

        detailContentMovieBinding.textGenre.text = tv?.genre

        detailContentMovieBinding.textCast.text = tv?.actrees

        detailContentMovieBinding.textOverview.text = tv?.overview

        detailContentMovieBinding.btnShare.setOnClickListener { onShareClick() }

        Glide.with(this)
                .load(tv?.image)

                .transform(RoundedCorners(10))

                .centerCrop()

                .apply(RequestOptions.placeholderOf(R.drawable.ic_image_search)

                        .error(R.drawable.ic_broken_image_gray))

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

            putExtra(Intent.EXTRA_TEXT, "https://www.themoviedb.org/")

            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)

        startActivity(shareIntent)
    }

}