package com.example.movie.ui.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.R
import com.example.movie.databinding.FragmentTvShowBinding
import com.example.movie.ui.other.SpaceItemDecoration
import com.example.movie.ui.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)

        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val modelFactory = ViewModelFactory.getInstance()

            val viewModel = ViewModelProvider(this, modelFactory)[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()

            fragmentTvShowBinding.progressBar.visibility = View.VISIBLE

            viewModel.getTvSHow().observe(this, { tvShow ->

                fragmentTvShowBinding.progressBar.visibility = View.GONE

                tvShowAdapter.setTvShow(tvShow)

                tvShowAdapter.notifyDataSetChanged()
            })

            with(fragmentTvShowBinding.rvTvShow) {

                val space = resources.getDimensionPixelSize(R.dimen.space_margin)

                val decoration = SpaceItemDecoration(1, space, true, 0)

                layoutManager = LinearLayoutManager(context)

                fragmentTvShowBinding.rvTvShow.addItemDecoration(decoration)

                setHasFixedSize(true)

                adapter = tvShowAdapter
            }
        }
    }
}