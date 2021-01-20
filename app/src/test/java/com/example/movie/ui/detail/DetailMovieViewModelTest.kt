package com.example.movie.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.movie.data.source.AllRepository
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow
import com.example.movie.utils.DataMovie
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel

    private val dummyMovies = DataMovie.generateDataMovie()[0]

    private val idMovie = dummyMovies.id

    private val dummyTvShows = DataMovie.generateDataTvShow()[0]

    private val idTvShow = dummyTvShows.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: AllRepository

    @Mock
    private lateinit var movieObserver: Observer<Movie>

    @Mock
    private lateinit var tvObserver: Observer<TvShow>


    @Before
    fun setUp() {

        viewModel = DetailMovieViewModel(movieRepository)

        viewModel.getDetailMovie(idMovie)

        viewModel.getDetailTvShow(idTvShow)

    }

    @Test
    fun getMovie() {

        val movies = MutableLiveData<Movie>()

        movies.value = dummyMovies

        `when`(movieRepository.getDetailMovie(idMovie)).thenReturn(movies)

        val movieEntities = viewModel.getDetailMovie(idMovie).value as Movie

        assertNotNull(movieEntities)

        assertEquals(dummyMovies.id, movieEntities.id)

        assertEquals(dummyMovies.title, movieEntities.title)

        assertEquals(dummyMovies.releaseDate, movieEntities.releaseDate)

        assertEquals(dummyMovies.originalLanguage, movieEntities.originalLanguage)

        assertEquals(dummyMovies.popularity, movieEntities.popularity)

        assertEquals(dummyMovies.voteCount, movieEntities.voteCount)

        assertEquals(dummyMovies.voteAverage, movieEntities.voteAverage)

        assertEquals(dummyMovies.overview, movieEntities.overview)

        assertEquals(dummyMovies.posterPath, movieEntities.posterPath)

        assertEquals(dummyMovies.backdropPath, movieEntities.backdropPath)

        viewModel.getDetailMovie(idMovie).observeForever(movieObserver)

        verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun getTvShow() {

        val tvShows = MutableLiveData<TvShow>()

        tvShows.value = dummyTvShows

        `when`(movieRepository.getDetailTvShow(idTvShow)).thenReturn(tvShows)

        val tvShowEntities = viewModel.getDetailTvShow(idTvShow).value as TvShow

        assertNotNull(tvShowEntities)

        assertEquals(dummyTvShows.id, tvShowEntities.id)

        assertEquals(dummyTvShows.name, tvShowEntities.name)

        assertEquals(dummyTvShows.firstAirDate, tvShowEntities.firstAirDate)

        assertEquals(dummyTvShows.originalLanguage, tvShowEntities.originalLanguage)

        assertEquals(dummyTvShows.popularity, tvShowEntities.popularity)

        assertEquals(dummyTvShows.voteCount, tvShowEntities.voteCount)

        assertEquals(dummyTvShows.voteAverage, tvShowEntities.voteAverage)

        assertEquals(dummyTvShows.overview, tvShowEntities.overview)

        assertEquals(dummyTvShows.posterPath, tvShowEntities.posterPath)

        assertEquals(dummyTvShows.backdropPath, tvShowEntities.backdropPath)

        viewModel.getDetailTvShow(idTvShow).observeForever(tvObserver)

        verify(tvObserver).onChanged(dummyTvShows)

    }
}