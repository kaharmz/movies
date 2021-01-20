package com.example.movie.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.movie.BuildConfig
import com.example.movie.R
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow
import com.example.movie.databinding.ActivityDetailMovieBinding
import com.example.movie.ui.viewmodel.ViewModelFactory
import com.example.movie.utils.StringHelper.ADD
import com.example.movie.utils.StringHelper.REMOVE
import com.example.movie.utils.loadImage
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DetailMovieActivity : DaggerAppCompatActivity(), DetailActivityCallback {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TYPE = "extra_type"
        const val TYPE_MOVIE = "type_movie"
        const val TYPE_TV = "type_tv"
    }

    private var _activityDetailMovieBinding: ActivityDetailMovieBinding? = null
    private val mainBinding get() = _activityDetailMovieBinding
    private val contentBinding get() = _activityDetailMovieBinding?.detailContent
    private lateinit var viewModel: DetailMovieViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(mainBinding?.root)
        setSupportActionBar(mainBinding?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val id = intent.getIntExtra(EXTRA_MOVIE, 0)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) detailMovie(id)
        else if (type.equals(TYPE_TV, ignoreCase = true)) detailTvShow(id)
    }

    private fun detailMovie(id: Int) {
        progressbarOn()
        viewModel.getDetailMovie(id).observe(this, { idMovie ->
            progressbarOff()
            getDetailDataMovie(idMovie)
        })
    }

    private fun getDetailDataMovie(movies: Movie?) {
        contentBinding?.textTitle?.text = movies?.title
        contentBinding?.textRelease?.text = movies?.releaseDate
        contentBinding?.textLanguage?.text = movies?.originalLanguage
        contentBinding?.textVoteAverage?.text = movies?.voteAverage.toString()
        contentBinding?.textVoteCount?.text = movies?.voteCount.toString()
        contentBinding?.textPopularity?.text = movies?.popularity.toString()
        contentBinding?.textOverview?.text = movies?.overview
        val image = movies?.backdropPath
        val statusFavorite = movies?.favorite
        contentBinding?.imagePoster?.loadImage(BuildConfig.BASE_BACKGROUND_URL + image)
        statusFavorite?.let {
            setFavoriteState(it)
        }
        mainBinding?.fabFavorite?.setOnClickListener {
            setFavoriteMovie(movies)
        }
    }

    private fun setFavoriteMovie(movies: Movie?) {
        if (movies != null) {
            when {
                movies.favorite -> Toast.makeText(
                    this, "${movies.title} " + REMOVE, Toast.LENGTH_SHORT
                ).show()
                else -> Toast.makeText(this, "${movies.title} " + ADD, Toast.LENGTH_SHORT).show()
            }
            viewModel.setFavoriteMovie(movies)
        }
    }

    private fun detailTvShow(id: Int) {
        progressbarOn()
        viewModel.getDetailTvShow(id).observe(this, { idTv ->
            progressbarOff()
            getDetailDataTv(idTv)
        })
    }

    private fun getDetailDataTv(tvShow: TvShow?) {
        contentBinding?.textTitle?.text = tvShow?.name
        contentBinding?.textRelease?.text = tvShow?.firstAirDate
        contentBinding?.textLanguage?.text = tvShow?.originalLanguage
        contentBinding?.textVoteAverage?.text = tvShow?.voteAverage.toString()
        contentBinding?.textVoteCount?.text = tvShow?.voteCount.toString()
        contentBinding?.textPopularity?.text = tvShow?.popularity.toString()
        contentBinding?.textOverview?.text = tvShow?.overview
        val image = tvShow?.backdropPath
        val statusFavorite = tvShow?.favorite
        contentBinding?.imagePoster?.loadImage(BuildConfig.BASE_BACKGROUND_URL + image)
        statusFavorite?.let {
            setFavoriteState(it)
        }

        mainBinding?.fabFavorite?.setOnClickListener {
            setFavorite(tvShow)
        }
    }

    private fun setFavorite(tvShow: TvShow?) {
        if (tvShow != null) {
            when {
                tvShow.favorite -> Toast.makeText(
                    this,
                    "${tvShow.name} " + REMOVE,
                    Toast.LENGTH_SHORT
                ).show()
                else -> Toast.makeText(this, "${tvShow.name} " + ADD, Toast.LENGTH_SHORT).show()
            }
            viewModel.setFavoriteTv(tvShow)
        }
    }

    private fun progressbarOff() {
        mainBinding?.progressBar?.visibility = View.GONE
        mainBinding?.scrollView?.visibility = View.VISIBLE
    }

    private fun progressbarOn() {
        mainBinding?.progressBar?.visibility = View.VISIBLE
        mainBinding?.scrollView?.visibility = View.INVISIBLE
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.share) onShareClick() else finish()
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
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

    private fun setFavoriteState(state: Boolean) {
        if (!state) mainBinding?.fabFavorite?.setImageResource(R.drawable.ic_favorite_border)
        else mainBinding?.fabFavorite?.setImageResource(R.drawable.ic_favorite)
    }
}