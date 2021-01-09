package com.example.movie.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {

    private const val RESOURCE = "GLOBAL"

    val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {

        espressoTestIdlingResource.increment()
    }

    fun decrement() {

        espressoTestIdlingResource.decrement()
    }

    fun getEspressoIdlingResourceForMainActivity(): IdlingResource = espressoTestIdlingResource


}