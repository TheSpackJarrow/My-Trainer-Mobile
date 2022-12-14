package com.example.mytrainermobile.viewModels

import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.screenStates.RoutineUIState
import kotlinx.coroutines.Job

interface DefaultViewModelInterface {
    fun loadRoutines(refresh:Boolean = false) : Job
    fun getRoutineList() : List<Routine>
    fun getState(): RoutineUIState
    fun toggleShowSortButton()
    fun toggleAuxSortDescending()
    fun toggleAuxSortingBy(sortingOption: String)
    fun saveChanges(): Job
    fun unSaveChanges()

    fun getScreenMode(width: Dp) : Boolean{
        return width > 700.dp
    }

    fun getSortSize(width: Dp): Dp {
        return if(getScreenMode(width))
            75.dp
        else
            30.dp
    }
}