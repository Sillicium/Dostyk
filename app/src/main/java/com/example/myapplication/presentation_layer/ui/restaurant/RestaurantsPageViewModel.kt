package com.example.myapplication.presentation_layer.ui.restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data_layer.model.SessionData
import com.example.myapplication.domain_layer.use_case.AuthUseCases.TestUseCase
import com.example.myapplication.domain_layer.use_case.collection.SessionManagingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantsPageViewModel @Inject constructor(
    private val testDataUseCases: SessionManagingUseCases
): ViewModel() {

    private var _sessionData = MutableLiveData<SessionData?>()
    val sessionData: LiveData<SessionData?> = _sessionData

    fun getBranchId() =
        testDataUseCases.testDataUseCase()
}