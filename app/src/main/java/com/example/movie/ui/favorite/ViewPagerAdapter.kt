package com.example.movie.ui.favorite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.movie.ui.favorite.movie.FavoriteMovieFragment
import com.example.movie.ui.favorite.tvshow.FavoriteTvShowFragment
import com.example.movie.utils.StringHelper.MOVIE
import com.example.movie.utils.StringHelper.TV_SHOW

class ViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private val TAB_TITLE = arrayListOf(MOVIE, TV_SHOW)
    }

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> FavoriteMovieFragment()
        1 -> FavoriteTvShowFragment()
        else -> Fragment()
    }

    override fun getPageTitle(position: Int): CharSequence? = TAB_TITLE[position]

    override fun getCount(): Int = 2


}