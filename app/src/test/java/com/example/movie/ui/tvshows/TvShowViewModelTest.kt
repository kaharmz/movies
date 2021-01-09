package com.example.movie.ui.tvshows


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.movie.data.TvShow
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    lateinit var observer: Observer<List<TvShow>>

    @Before
    fun setUp() {

        viewModel = TvShowViewModel(movieRepository)

    }

    @Test
    fun getTvShow() {

        val dummyTvShow = DataMovie.generateDataTvShow()

        val tvSHow = MutableLiveData<List<TvShow>>()

        tvSHow.value = dummyTvShow

        `when`(movieRepository.getAllTvShow()).thenReturn(tvSHow)

        val tvEntities = viewModel.getTvSHow().value

        verify(movieRepository).getAllTvShow()

        assertNotNull(tvEntities)

        assertEquals(10, tvEntities?.size)

        viewModel.getTvSHow().observeForever(observer)

        verify(observer).onChanged(dummyTvShow)
    }
}