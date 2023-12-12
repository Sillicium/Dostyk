package com.example.myapplication.data_layer.network.repo

import com.example.myapplication.data_layer.network.NetworkResult
import com.example.myapplication.data_layer.network.handleRequest
import com.example.myapplication.data_layer.network.apiService.MainApiService
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(private val apiService: MainApiService) :
    TestRepository {

    override suspend fun getPopularMovies()  = flow {
        emit(NetworkResult.Loading(true))
        val response = apiService.getMostPopularMovies()
        emit(NetworkResult.Success(response.items))

    }.catch { e ->

        emit(NetworkResult.Exception(e, e.message ?: "Unknown Error"))
    }


    override suspend fun getMoviesFlow() = flow {
        emit(NetworkResult.Loading(true))
        val response = apiService.getMostMovieFlow()
        emit(NetworkResult.Success(response))
    }.catch { e ->
        emit(NetworkResult.Exception(e, e.message ?: "Unknown Error"))
    }

    override suspend fun getMovies() =
        handleRequest { apiService.getMostMovie() }
}