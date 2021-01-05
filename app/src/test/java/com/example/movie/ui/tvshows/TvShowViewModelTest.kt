package com.example.movie.ui.tvshows


import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {

        viewModel = TvShowViewModel()

    }

    @Test
    fun getTvShow() {

        val tvShow = viewModel.getTvShow()

        assertNotNull(tvShow)

        assertEquals(10, tvShow.size)
    }
}