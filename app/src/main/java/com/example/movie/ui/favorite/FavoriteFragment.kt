package com.example.movie.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movie.databinding.FragmentFavoriteBinding
import dagger.android.support.DaggerFragment


class FavoriteFragment : DaggerFragment() {

    private lateinit var favoriteBinding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        favoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return favoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)
        favoriteBinding.viewPager.adapter = viewPagerAdapter
        favoriteBinding.tabs.setupWithViewPager(favoriteBinding.viewPager)
    }
}