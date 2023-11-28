package com.example.myapplication.data

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
