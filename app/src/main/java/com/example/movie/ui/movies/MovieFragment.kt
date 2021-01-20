package com.example.movie.ui.movies

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movie.R
import com.example.movie.databinding.FragmentMovieBinding
import com.example.movie.ui.home.HomeViewModel
import com.example.movie.ui.other.SpaceItemDecoration
import com.example.movie.ui.viewmodel.ViewModelFactory
import com.example.movie.ui.vo.DataStatus
import com.example.movie.utils.StringHelper.ERROR
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MovieFragment : DaggerFragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
            val movieAdapter = MovieAdapter()
            viewModel.getListMovie().observe(this, { movies ->
                if (movies != null) when (movies.status) {
                    DataStatus.LOADING -> fragmentMovieBinding.progressBar.visibility =
                        View.VISIBLE
                    DataStatus.SUCCESS -> {
                        fragmentMovieBinding.progressBar.visibility = View.GONE
                        movieAdapter.submitList(movies.data)
                    }
                    DataStatus.ERROR -> {
                        fragmentMovieBinding.progressBar.visibility = View.GONE
                        Toast.makeText(context, ERROR, Toast.LENGTH_SHORT).show()
                    }
                }
            })
            with(fragmentMovieBinding.rvMovie) {
                val space = resources.getDimensionPixelSize(R.dimen.space_margin)
                val decoration = SpaceItemDecoration(2, space, true, 0)
                when (this.resources.configuration.orientation) {
                    Configuration.ORIENTATION_PORTRAIT -> this.layoutManager =
                        GridLayoutManager(context, 2)
                    else -> this.layoutManager = GridLayoutManager(context, 4)
                }
                fragmentMovieBinding.rvMovie.addItemDecoration(decoration)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}

