package com.example.myapplication.data_layer.model

import com.google.gson.annotations.SerializedName

data class TemporaryDataClassOneElement(
    val first: Int
)

data class TemporaryDataClassTwoElement(
    val first: Int,
    val second: Int,
)

data class TemporaryDataClassThreeElement(
    val first: Int,
    val second: Int,
    val third: Int
)

data class TemporaryDataClassWithList(
    val first: Int,
    val second: List<TemporaryDataClassThreeElement>,
)

data class Movie(
    val id: String,
    val title: String,
    val year: String,
    val image: String,
    val imDbRating: String
)

data class MovieResponse(val items: List<Movie>, val errorMessage: String)

data class SessionData(
    @SerializedName("access_token"  ) var accessToken  : String,
    @SerializedName("refresh_token" ) val refreshToken : String,
    @SerializedName("expires_at"    ) val expiresAt    : Int,
    @SerializedName("ttl"           ) val ttl          : Int
)
