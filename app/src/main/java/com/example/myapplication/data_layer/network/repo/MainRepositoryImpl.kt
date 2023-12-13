package com.example.myapplication.data_layer.network.repo

import com.example.myapplication.data_layer.network.apiService.MainApiService
import com.example.myapplication.data_layer.network.handleRequest
import com.example.myapplication.data_layer.network.handleRequestAsFlow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val apiService: MainApiService
): MainRepository {

    override suspend fun refreshToken(refreshToken: String) =
        handleRequest {
            apiService.refreshToken(refreshToken)
        }

    override suspend fun startSession(authCode: String) =
        handleRequestAsFlow { apiService.authenticateUser(authCode) }
}