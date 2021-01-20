package com.example.movie.ui.home

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.movie.R
import com.example.movie.databinding.ActivityHomeBinding
import com.example.movie.ui.favorite.FavoriteFragment
import com.example.movie.ui.movies.MovieFragment
import com.example.movie.ui.tvshows.TvShowFragment
import com.example.movie.ui.viewmodel.ViewModelFactory
import com.example.movie.utils.StringHelper.FAVORITE
import com.example.movie.utils.StringHelper.MOVIE
import com.example.movie.utils.StringHelper.TV_SHOW
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)
        supportActionBar?.elevation = 0f
        viewModel = ViewModelProvider(this@HomeActivity, factory)[HomeViewModel::class.java]
        activityHomeBinding.navigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.movie -> addFragmentMovie(savedInstanceState)
                R.id.tv -> addFragmentTv(savedInstanceState)
                R.id.favorite -> addFragmentFavorite(savedInstanceState)
            }
            true
        }
        activityHomeBinding.navigation.selectedItemId = R.id.movie
    }

    private fun addFragmentMovie(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container, MovieFragment(),
                MovieFragment::class.java.simpleName
            )
            .commit()
        supportActionBar?.title = MOVIE
    }

    private fun addFragmentTv(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container, TvShowFragment(),
                TvShowFragment::class.java.simpleName
            )
            .commit()
        supportActionBar?.title = TV_SHOW
    }

    private fun addFragmentFavorite(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container,
                FavoriteFragment(),
                FavoriteFragment::class.java.simpleName
            )
            .commit()
        supportActionBar?.title = FAVORITE
    }

}