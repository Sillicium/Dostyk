package com.example.myapplication.data_layer.network.apiService

import com.example.myapplication.data_layer.model.Movie
import com.example.myapplication.data_layer.model.MovieResponse
import com.example.myapplication.data_layer.model.SessionData
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MainApiService {

    @GET("510fb38a-4326-4d9c-b079-07281d51570e")
    suspend fun getMostPopularMovies() : MovieResponse

    @GET("510fb38a-4326-4d9c-b079-07281d51570e")
    suspend fun getMostMovie() : Response<List<Movie>>

    @GET("510fb38a-4326-4d9c-b079-07281d51570e")
    suspend fun getMostMovieFlow() : List<Movie>


    //    AUTH
    @FormUrlEncoded
//    @POST("/v1/auth/sessions")
    suspend fun authenticateUser(
        @Field("auth_code") authCode: String,
    ) : Response<SessionData>

    @FormUrlEncoded
//    @POST("/v1/oauth/token")
    suspend fun refreshToken(
        @Field("refresh_token") refreshToken: String,
        @Field("grant_type") grantType: String = "refresh_token",
    ) : Response<SessionData>

    /*@GET("510fb38a-4326-4d9c-b079-07281d51570e")
    suspend fun getMostPopularMovies() : MovieResponse
    //https://run.mocky.io/v3/510fb38a-4326-4d9c-b079-07281d51570e*/
}