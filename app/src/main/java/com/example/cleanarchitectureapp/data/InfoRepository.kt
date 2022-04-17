package com.example.cleanarchitectureapp.data

import com.example.cleanarchitectureapp.domain.InfoDomain

interface InfoRepository {

    fun info(): InfoDomain

    class TestSuccess : InfoRepository {
        override fun info() = InfoDomain.Success("It is", "\nSuccess!")
    }
}