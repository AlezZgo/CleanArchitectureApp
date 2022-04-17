package com.example.cleanarchitectureapp.domain

import com.example.cleanarchitectureapp.data.InfoRepository
import java.lang.Exception

interface InfoInteractor {

    suspend fun info(): InfoDomain

    class Base(private val repository: InfoRepository) : InfoInteractor {
        override suspend fun info() = try {
            repository.info()
        } catch (e : Exception) {
            InfoDomain.Failure(e.message?:"Unknown exception")
        }

    }
}