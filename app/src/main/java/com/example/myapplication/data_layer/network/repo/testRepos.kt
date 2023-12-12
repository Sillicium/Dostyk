package com.example.myapplication.data_layer.network.repo

import com.example.myapplication.data_layer.model.Movie
import com.example.myapplication.data_layer.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface TestRepository {

    suspend fun getPopularMovies(): Flow<NetworkResult<List<Movie>>>

    suspend fun getMoviesFlow(): Flow<NetworkResult<List<Movie>>>

    suspend fun getMovies(): NetworkResult<List<Movie>>
}