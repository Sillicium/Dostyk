package com.example.myapplication.data_layer.interceptors

import com.example.myapplication.data_layer.network.sessionManager.auth.AuthenticationSessionManager
import okhttp3.Request
import javax.inject.Inject

class AuthInterceptorImpl @Inject constructor(
    override val sessionManager: AuthenticationSessionManager
) : BaseAuthInterceptor {
    override fun newRequestWithAccessToken(accessToken: String?, request: Request): Request {
//
//        val clientID = when(getAppType()){
//            APP_TYPES.client -> ClientHeaders.CLIENT_ID
//            APP_TYPES.merchant -> MerchantHeaders.CLIENT_ID
//        }
//
//        val clientSecret = when(getAppType()){
//            APP_TYPES.client -> ClientHeaders.CLIENT_SECRET
//            APP_TYPES.merchant -> MerchantHeaders.CLIENT_SECRET
//        }

        return request.newBuilder()
            .addHeader("Authorization", "Bearer $accessToken")
//            .addHeader(GeneralHeaders.CLIENT_SECRET_HEADER_NAME, clientSecret)
//            .addHeader(GeneralHeaders.CLIENT_ID_HEADER_NAME, clientID)
            .build()
    }
}