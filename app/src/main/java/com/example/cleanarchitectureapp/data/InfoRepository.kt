package com.example.cleanarchitectureapp.data

import com.example.cleanarchitectureapp.domain.InfoDomain
import kotlinx.coroutines.delay

interface InfoRepository {

    suspend fun info(): InfoDomain

    class TestSuccess : InfoRepository {
        override suspend fun info(): InfoDomain {
            delay(2000)
            return InfoDomain.Success("It is", "\nSuccess!")
        }
    }

}