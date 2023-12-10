package com.example.myapplication.network.use_case.collection

import com.example.myapplication.network.use_case.AuthUseCases.ClearSessionDataUseCase
import javax.inject.Inject


data class SessionManagingUseCases @Inject constructor(
//    val authUserUseCase: StartSessionUseCase,
//    val saveSessionDataUseCase: SaveSessionDataUseCase,
//    val startGoogleAuthUseCase: StartGoogleAuthUseCase,
//    val refreshSessionDataUseCase: RefreshSessionDataUseCase,
    val clearSessionDataUseCase: ClearSessionDataUseCase,
)