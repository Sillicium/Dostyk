package com.example.myapplication.network.sessionManager

import com.example.myapplication.data.SessionData
import com.example.myapplication.network.repo.data_store.BaseDataStoreRepo
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