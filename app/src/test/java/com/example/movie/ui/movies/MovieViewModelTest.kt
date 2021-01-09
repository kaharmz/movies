package com.example.movie.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.movie.data.Movie
import com.example.movie.data.source.MovieRepository
import com.example.movie.utils.DataMovie
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<Movie>>

    @Before
    fun setUp() {

        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovie() {

        val dummyMovie = DataMovie.generateDataMovie()

        val movie = MutableLiveData<List<Movie>>()

        movie.value = dummyMovie

        `when`(movieRepository.getAllMovie()).thenReturn(movie)

        val movieEntities = viewModel.getMovie().value

        verify(movieRepository).getAllMovie()

        assertNotNull(movieEntities)

        assertEquals(10, movieEntities?.size)

        viewModel.getMovie().observeForever(observer)

        verify(observer).onChanged(dummyMovie)
    }
}