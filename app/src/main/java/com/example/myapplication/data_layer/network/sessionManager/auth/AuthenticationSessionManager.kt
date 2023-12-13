package com.example.myapplication.data_layer.network.sessionManager.auth



import android.util.Log
import com.example.myapplication.data_layer.model.SessionData
import com.example.myapplication.data_layer.network.NetworkResult
import com.example.myapplication.data_layer.network.repo.data_store.BaseDataStoreRepo
import com.example.myapplication.data_layer.network.apiService.AuthApiService
import com.example.myapplication.data_layer.network.apiService.MainApiService
import com.example.myapplication.data_layer.network.handleRequest
import com.example.myapplication.data_layer.network.sessionManager.BaseSessionManager
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class AuthenticationSessionManager @Inject constructor(

    override val pref: BaseDataStoreRepo,

    private val apiService: MainApiService

) : BaseSessionManager {

    fun setSessionData(data: SessionData){
        return runBlocking {
            pref.setAuthSessionData(data)
        }
    }

    override fun refreshToken(refreshToken: String, oldAccessToken: String): String {
//    Returns oldAccessToken on Error and etc
        return runBlocking {
            when(val response = handleRequest {apiService.refreshToken(refreshToken)}) {
                is NetworkResult.Loading -> {
//                    this request is done without Loading state
                    oldAccessToken
                }
                is NetworkResult.Exception -> {
                    Log.d(ON_INTERCEPT_TAG, "${response.error} - ${response.errorMessage}")
                    clearSessionData()
                    oldAccessToken
                }

                is NetworkResult.RequestError -> {
                    Log.d(ON_INTERCEPT_TAG, "${response.code} - ${response.message}")
                    clearSessionData()
                    oldAccessToken
                }

                is  NetworkResult.Success -> {
                    pref.setAuthSessionData(response.data)

                    response.data.accessToken
                }
            }
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