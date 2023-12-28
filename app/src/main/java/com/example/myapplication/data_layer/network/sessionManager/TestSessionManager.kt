package com.example.myapplication.data_layer.network.sessionManager

import com.example.myapplication.data_layer.network.apiService.MainApiService
import com.example.myapplication.data_layer.network.repo.TestRepository
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class TestSessionManager @Inject constructor(

    override val pref: TestRepository,

    private val apiService: MainApiService

) : TestBaseSessionManager {


    override fun testRequest() {
        return runBlocking {
            pref.getPopularMovies()
        }
    }


}