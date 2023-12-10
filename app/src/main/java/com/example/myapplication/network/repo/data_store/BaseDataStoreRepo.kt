package com.example.myapplication.network.repo.data_store

import com.example.myapplication.data.SessionData

interface BaseDataStoreRepo {

    suspend fun getRefreshToken(): String

    suspend fun getAccessToken(): String

    suspend fun setAuthSessionData(
        data: SessionData
    )

    suspend fun getAuthSessionData(): SessionData?

    suspend fun deleteAuthSessionData()

}