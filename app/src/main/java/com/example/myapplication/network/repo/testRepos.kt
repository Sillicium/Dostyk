package com.example.myapplication.network.repo

import com.example.myapplication.data.Movie
import com.example.myapplication.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface TestRepository {

    suspend fun getPopularMovies(): Flow<NetworkResult<List<Movie>>>

    suspend fun getMoviesFlow(): Flow<NetworkResult<List<Movie>>>

    suspend fun getMovies(): NetworkResult<List<Movie>>
}