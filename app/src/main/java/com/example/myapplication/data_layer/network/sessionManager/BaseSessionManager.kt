package com.example.myapplication.data_layer.network.sessionManager

import com.example.myapplication.data_layer.network.repo.data_store.BaseDataStoreRepo
import kotlinx.coroutines.runBlocking

interface BaseSessionManager {

    val pref: BaseDataStoreRepo

    fun getAccessToken(): String {
        return runBlocking {
            pref.getAccessToken()
        }
    }

    fun clearSessionData()
}