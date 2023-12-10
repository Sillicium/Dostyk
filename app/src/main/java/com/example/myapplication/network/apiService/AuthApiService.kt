package com.example.myapplication.network.apiService

import com.example.myapplication.data.SessionData
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface AuthApiService {

    @POST("api/auth/signin")
    suspend fun authenticateUser(
        @Body requestBody: RequestBody
    ) : Response<SessionData>

    @POST("api/content/v1/device")
    suspend fun sendFirebaseToken(
        @Body requestBody: RequestBody,
        ) : Response<Unit>

    @PUT("api/content/v1/device")
    suspend fun setDeviceNotificationState(
        @Body requestBody: RequestBody,
        ) : Response<Unit>

}