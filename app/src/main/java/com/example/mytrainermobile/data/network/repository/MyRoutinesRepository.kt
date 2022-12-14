package com.example.mytrainermobile.data.network.repository

import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.data.network.MyRoutineRemoteDataSource
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.*

class MyRoutinesRepository(private val remoteDataSource : MyRoutineRemoteDataSource) {

    private val routinesMutex = Mutex()
    private var routines: List<Routine> = emptyList()

    suspend fun getRoutines(refresh: Boolean = false): List<Routine> {
        if( refresh || routines.isEmpty()){
            val result = remoteDataSource.getRoutines()
            routinesMutex.withLock {
                this.routines = result.content.map { it.asModel() }
            }
        }
        return routinesMutex.withLock { this.routines }
    }

    suspend fun getRoutinesBySearch(query: String): List<Routine> {
        val allRoutines = remoteDataSource.getRoutines()
        routinesMutex.withLock {
            this.routines = allRoutines.content.filter{ it.name.lowercase(Locale.getDefault()).equals(query.lowercase(
                Locale.getDefault()
            ))}.map { it.asModel() }
        }
        return routinesMutex.withLock { this.routines }
    }

    suspend fun getCurrentUserRoutinesSorted(order: String, dir: String): List<Routine> {
        val filteredRoutines = remoteDataSource.getCurrentUserRoutinesSorted(order, dir)
        routinesMutex.withLock {
            this.routines = filteredRoutines.content.map { it.asModel() }
        }
        return routinesMutex.withLock { this.routines }
    }

}