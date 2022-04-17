package com.example.cleanarchitectureapp.domain

import com.example.cleanarchitectureapp.data.InfoRepository

interface InfoInteractor {

    suspend fun info(): InfoDomain

    class Base(private val repository: InfoRepository) : InfoInteractor {
        override suspend fun info() = repository.info()
    }
}