package com.example.movie.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movie.R
import com.example.movie.databinding.FragmentMovieBinding
import com.example.movie.ui.other.SpaceItemDecoration
import com.example.movie.ui.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)

        return fragmentMovieBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val modelFactory = ViewModelFactory.getInstance()

            val viewModel = ViewModelProvider(this, modelFactory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()

            fragmentMovieBinding.progressBar.visibility = View.VISIBLE

            viewModel.getMovie().observe(this, { movies ->

                fragmentMovieBinding.progressBar.visibility = View.GONE

                movieAdapter.setMovie(movies)

                movieAdapter.notifyDataSetChanged()
            })

            with(fragmentMovieBinding.rvMovie) {

                val space = resources.getDimensionPixelSize(R.dimen.space_margin)

                val decoration = SpaceItemDecoration(2, space, true, 0)

                layoutManager = GridLayoutManager(context, 2)

                fragmentMovieBinding.rvMovie.addItemDecoration(decoration)

                setHasFixedSize(true)

                adapter = movieAdapter
            }

        }
    }

}

