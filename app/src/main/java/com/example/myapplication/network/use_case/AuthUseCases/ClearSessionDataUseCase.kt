package com.example.myapplication.network.use_case.AuthUseCases

import com.example.myapplication.network.sessionManager.auth.AuthenticationSessionManager
import javax.inject.Inject


class ClearSessionDataUseCase @Inject constructor(
    private val sessionManager: AuthenticationSessionManager
) {
    operator fun invoke() {
        return sessionManager.clearSessionData()
    }
}