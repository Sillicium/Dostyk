package com.example.myapplication.domain_layer.use_case.AuthUseCases

import com.example.myapplication.data_layer.network.sessionManager.auth.AuthenticationSessionManager
import javax.inject.Inject


class ClearSessionDataUseCase @Inject constructor(
    private val sessionManager: AuthenticationSessionManager
) {
    operator fun invoke() {
        return sessionManager.clearSessionData()
    }
}