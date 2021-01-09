package com.example.movie.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movie.data.source.remote.*
import com.example.movie.utils.DataMovie
import com.example.movie.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var remote = mock(RemoteDataSource::class.java)

    private val movieMovieRepository = FakeMovieMovieRepository(remote)

    private val listMovieResponses = DataMovie.generateRemoteDataMovie()

    private val movieId = listMovieResponses[0].id

    private val listTvResponses = DataMovie.generateRemoteDataTvShow()

    private val tvId = listTvResponses[0].id

    private val movieResponse = DataMovie.generateRemoteDataMovie()[0]

    private val tvResponse = DataMovie.generateRemoteDataTvShow()[0]

    @Test
    fun getAllMovie() {

        runBlocking {

            doAnswer { invocation ->

                (invocation.arguments[0] as LoadMovieCallback)

                        .onAllMovieReceived(listMovieResponses)
                null

            }.`when`(remote).getMovies(any())
        }

        val data = LiveDataTestUtil.getValue(movieMovieRepository.getAllMovie())

        runBlocking {

            verify(remote).getMovies(any())

        }

        assertNotNull(data)

        assertEquals(listMovieResponses.size.toLong(), data.size.toLong())
    }

    @Test
    fun getAllTvShow() {

        runBlocking {

            doAnswer { invocation ->

                (invocation.arguments[0] as LoadTvShowCallback)

                        .onAllTvReceived(listTvResponses)

                null
            }.`when`(remote).getTvShow(any())
        }

        val data = LiveDataTestUtil.getValue(movieMovieRepository.getAllTvShow())

        runBlocking {

            verify(remote).getTvShow(any())
        }

        assertNotNull(data)

        assertEquals(listTvResponses.size.toLong(), data.size.toLong())
    }

    @Test
    fun getMovieDetailById() {

        runBlocking {

            doAnswer { invocation ->

                (invocation.arguments[1] as LoadDetailMovieCallback).loadDetailMovie(movieResponse)

                null
            }.`when`(remote).getMovieDetail(eq(movieId), any())
        }

        val data = LiveDataTestUtil.getValue(movieMovieRepository.getDetailMovie(movieId))

        runBlocking {

            verify(remote).getMovieDetail(eq((movieId)), any())
        }

        assertNotNull(data)

        assertEquals(movieResponse.id, data.id)
    }

    @Test
    fun getTvShowDetailById() {

        runBlocking {

            doAnswer { invocation ->

                (invocation.arguments[1] as LoadDetailTvShowCallback).loadDetailTvShow(tvResponse)

                null
            }.`when`(remote).getTvShowDetail(eq(tvId), any())
        }

        val data = LiveDataTestUtil.getValue(movieMovieRepository.getDetailTvShow(tvId))

        runBlocking {

            verify(remote).getTvShowDetail(eq(tvId), any())
        }

        assertNotNull(data)

        assertEquals(tvResponse.id, data.id)
    }
}