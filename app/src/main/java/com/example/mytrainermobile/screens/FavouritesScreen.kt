package com.example.mytrainermobile.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.RoutineBox
import com.example.mytrainermobile.components.ScreenDescription
import com.example.mytrainermobile.viewModels.FavouriteViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.util.getFavouriteViewModelFactory

@Composable
fun FavouritesView(
    onNavigateToStartWorkout: (id:Int) -> Unit,
    viewModel: FavouriteViewModel = viewModel(factory = getFavouriteViewModelFactory())
    ) {
        val routinesList = viewModel.uiState.favouriteRoutines.orEmpty()

        ScreenDescription(title = stringResource(id = R.string.myfavourites))

        LazyVerticalGrid(

            modifier = Modifier
                .fillMaxSize()
                .padding(),
            contentPadding = PaddingValues(5.dp, 0.dp, 5.dp, 80.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalArrangement = Arrangement.Center,
            columns = GridCells.Adaptive(150.dp),
            content = {
                items(routinesList.size) { idx ->
                    RoutineBox(routine = routinesList[idx], onNavigateToStartWorkout)
                }
            }
        )
    }
