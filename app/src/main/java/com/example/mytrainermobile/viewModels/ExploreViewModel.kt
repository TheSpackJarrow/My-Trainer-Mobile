package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.data.network.repository.RoutineRepository
import com.example.mytrainermobile.screenStates.ExploreState
import com.example.mytrainermobile.ui.main.MainUiState
import com.example.mytrainermobile.util.SessionManager
import kotlinx.coroutines.launch

class ExploreViewModel(
    private val sessionManager: SessionManager,
    private val routineRepository: RoutineRepository
    ) : ViewModel(){

    var uiState by mutableStateOf(ExploreState(isAuthenticated = sessionManager.loadAuthToken() != null))
        private set

    init {
        getRoutines()
    }

     fun getRoutines() = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            routineRepository.getRoutines(true)
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
                routines = response
            )
        }.onFailure { e ->
            uiState = uiState.copy(
                message = e.message,
                isFetching = false
            )
        }
    }

    fun getRoutinesBySearch(query: String) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            routineRepository.getRoutinesBySearch(query)
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
                searchRoutines = response
            )
        }.onFailure { e ->
            uiState = uiState.copy(
                message = e.message,
                isFetching = false
            )
        }
    }
}