package com.example.cleanarchitectureapp.data

import com.example.cleanarchitectureapp.domain.InfoDomain
import kotlinx.coroutines.delay
import java.lang.RuntimeException

interface InfoRepository {

    suspend fun info(): InfoDomain

    class TestSuccess : InfoRepository {
        override suspend fun info(): InfoDomain {
            delay(2000)
            return InfoDomain.Success("It is", "\nSuccess!")
        }
    }

    class TestFailure : InfoRepository {
        override suspend fun info(): InfoDomain {
            delay(2000)
            throw RuntimeException("something going wrong")
        }
    }

}