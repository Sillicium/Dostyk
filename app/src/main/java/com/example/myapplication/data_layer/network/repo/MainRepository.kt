package com.example.myapplication.data_layer.network.repo

import com.example.myapplication.data_layer.model.SessionData
import com.example.myapplication.data_layer.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    //    AUTH
    suspend fun refreshToken(refreshToken: String): NetworkResult<SessionData>

    suspend fun startSession(
        authCode: String
    ) : Flow<NetworkResult<SessionData>>
}