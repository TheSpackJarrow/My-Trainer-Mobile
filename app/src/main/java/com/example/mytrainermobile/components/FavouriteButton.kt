package com.example.mytrainermobile.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.R
import com.example.mytrainermobile.data.model.Routine
import kotlinx.coroutines.Job

@Composable
fun FavouriteButton(
    routine: Routine,
    callbackMakeFavourite: (routineId: Int) -> Job,
    callbackRemoveFavourite: (routineId: Int) -> Job
) {
    val color = if (routine.isFavourite) Color.Red else Color.White
    IconButton(onClick = {
        if (routine.isFavourite)
            callbackRemoveFavourite(routine.id)
        else
            callbackMakeFavourite(routine.id)
    }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier.size(35.dp),
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favorite",
                tint = color,
            )
            Text(text = stringResource(id = R.string.favourite), color = Color.White)
        }

    }
}
