package com.example.corrutinasflow.data.domain

import com.example.corrutinasflow.data.model.SportEntity
import com.example.corrutinasflow.data.repository.SportListRepository
import javax.inject.Inject

class SportListUserCase @Inject constructor(
    private val repository: SportListRepository
) {

    suspend fun getSportListUserCase(): List<SportEntity> = repository.getSportListRepository()
}