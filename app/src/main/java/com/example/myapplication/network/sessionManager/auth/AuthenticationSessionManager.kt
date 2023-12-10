package com.example.myapplication.network.sessionManager.auth



import com.example.myapplication.data.SessionData
import com.example.myapplication.network.repo.data_store.BaseDataStoreRepo
import com.example.myapplication.network.apiService.AuthApiService
import com.example.myapplication.network.sessionManager.BaseSessionManager
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class AuthenticationSessionManager @Inject constructor(

    override val pref: BaseDataStoreRepo,

    private val apiService: AuthApiService

) : BaseSessionManager {

    fun setSessionData(data: SessionData){
        return runBlocking {
            pref.setAuthSessionData(data)
        }
    }

    override fun clearSessionData(){
        return runBlocking {
            pref.deleteUserData()
        }
    }



    companion object{

        private const val ON_INTERCEPT_TAG = "ON_INTERCEPT_REQUEST"

        private const val REFRESH_SESSION_TAG = "ON_CUSTOM_REFRESH"

    }

}