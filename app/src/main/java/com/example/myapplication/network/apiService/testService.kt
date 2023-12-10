package com.example.myapplication.network.apiService

import com.example.myapplication.data.Movie
import com.example.myapplication.data.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface TestApiService {

    @GET("510fb38a-4326-4d9c-b079-07281d51570e")
    suspend fun getMostPopularMovies() : MovieResponse

    @GET("510fb38a-4326-4d9c-b079-07281d51570e")
    suspend fun getMostMovie() : Response<List<Movie>>

    @GET("510fb38a-4326-4d9c-b079-07281d51570e")
    suspend fun getMostMovieFlow() : List<Movie>

    /*@GET("510fb38a-4326-4d9c-b079-07281d51570e")
    suspend fun getMostPopularMovies() : MovieResponse
    //https://run.mocky.io/v3/510fb38a-4326-4d9c-b079-07281d51570e*/
}