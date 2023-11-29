package com.example.myapplication.network.interceptors

import android.util.Log
import com.example.myapplication.network.sessionManager.BaseSessionManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.net.HttpURLConnection

interface BaseAuthInterceptor: Interceptor {
    val sessionManager: BaseSessionManager

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val accessToken = sessionManager.getAccessToken()


        val response = chain.proceed(newRequestWithAccessToken(accessToken, request))

        if (response.code == HttpURLConnection.HTTP_UNAUTHORIZED) {
//            val refreshToken = sessionManager.getRefreshToken()
//            val newAccessToken = sessionManager.refreshToken(refreshToken, accessToken)

//            return if (newAccessToken != accessToken) {
//                chain.proceed(newRequestWithAccessToken(accessToken, request))
//            } else {
////                TODO check if should delete line below
////                sessionManager.logout()
//                response
//            }
        }

        return response
    }

    fun newRequestWithAccessToken(accessToken: String?, request: Request): Request
}