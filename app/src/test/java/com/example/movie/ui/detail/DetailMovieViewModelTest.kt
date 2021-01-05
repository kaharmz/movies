package com.example.movie.ui.detail

import com.example.movie.utils.DataMovie
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel

    private val movies = DataMovie.generateDataMovie()[0]

    private val idMovie = movies.id

    private val tvShows = DataMovie.generateDataTvShow()[0]

    private val idTvShow = tvShows.id

    @Before
    fun setUp() {

        viewModel = DetailMovieViewModel()

        viewModel.setSelectedMovie(idMovie)

        viewModel.setSelectedMovie(idTvShow)
    }

    @Test
    fun getMovie() {

        viewModel.setSelectedMovie(movies.id)

        val movie = viewModel.getMovie()

        assertNotNull(movies)

        assertEquals(movie.id, movies.id)

        assertEquals(movie.image, movies.image)

        assertEquals(movie.title, movies.title)

        assertEquals(movie.subTitle, movies.subTitle)

        assertEquals(movie.dateRelease, movies.dateRelease)

        assertEquals(movie.genre, movies.genre)

        assertEquals(movie.actrees, movies.actrees)

        assertEquals(movie.overview, movies.overview)
    }

    @Test
    fun getTvShow() {

        viewModel.setSelectedMovie(tvShows.id)

        val tvShow = viewModel.getTvShow()

        assertNotNull(tvShows)

        assertEquals(tvShow.id, tvShows.id)

        assertEquals(tvShow.image, tvShows.image)

        assertEquals(tvShow.title, tvShows.title)

        assertEquals(tvShow.subTitle, tvShows.subTitle)

        assertEquals(tvShow.dateRelease, tvShows.dateRelease)

        assertEquals(tvShow.genre, tvShows.genre)

        assertEquals(tvShow.actrees, tvShows.actrees)

        assertEquals(tvShow.overview, tvShows.overview)

    }
}