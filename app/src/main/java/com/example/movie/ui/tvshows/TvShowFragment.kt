package com.example.movie.ui.tvshows

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.databinding.FragmentTvShowBinding
import com.example.movie.ui.home.HomeViewModel
import com.example.movie.ui.other.SpaceItemDecoration
import com.example.movie.ui.viewmodel.ViewModelFactory
import com.example.movie.ui.vo.DataStatus
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TvShowFragment : DaggerFragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
            val tvAdapter = TvShowAdapter()
            viewModel.getListTvShow().observe(this, { tv ->
                if (tv != null) when (tv.status) {
                    DataStatus.LOADING -> fragmentTvShowBinding.progressBar.visibility =
                        View.VISIBLE
                    DataStatus.SUCCESS -> {
                        fragmentTvShowBinding.progressBar.visibility = View.GONE
                        tvAdapter.submitList(tv.data)
                    }
                    DataStatus.ERROR -> {
                        fragmentTvShowBinding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            })
            with(fragmentTvShowBinding.rvTvShow) {
                val space = resources.getDimensionPixelSize(com.example.movie.R.dimen.space_margin)
                val decoration = SpaceItemDecoration(4, space, true, 0)
                when (this.resources.configuration.orientation) {
                    Configuration.ORIENTATION_PORTRAIT -> this.layoutManager =
                        LinearLayoutManager(context)
                    else -> this.layoutManager = GridLayoutManager(context, 2)
                }
                fragmentTvShowBinding.rvTvShow.addItemDecoration(decoration)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }
}