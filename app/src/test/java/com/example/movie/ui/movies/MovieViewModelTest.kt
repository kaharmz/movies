package com.example.movie.ui.movies

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {

        viewModel = MovieViewModel()
    }

    @Test
    fun getMovie() {

        val movies = viewModel.getMovie()

        assertNotNull(movies)

        assertEquals(10, movies.size)
    }
}