package com.example.myapplication.network.repo.data_store

interface BaseDataStoreRepo {


    suspend fun getAccessToken(): String
}