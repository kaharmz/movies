package com.example.movie.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.movie.R
import com.example.movie.ui.movies.MovieFragment
import com.example.movie.ui.tvshows.TvShowFragment

class SectionPagerAdapter(private val context: Context, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {

        @StringRes

        private val TAB_TITLE = intArrayOf(R.string.movie, R.string.tvShow)
    }

    override fun getItem(position: Int): Fragment = when (position) {

        0 -> MovieFragment()

        1 -> TvShowFragment()

        else -> Fragment()
    }

    override fun getPageTitle(position: Int): CharSequence? = context.resources.getString(TAB_TITLE[position])

    override fun getCount(): Int = 2
}