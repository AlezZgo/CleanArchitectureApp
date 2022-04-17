package com.example.cleanarchitectureapp.domain

import com.example.cleanarchitectureapp.data.InfoRepository

interface InfoInteractor {

    fun info(): InfoDomain

    class Base(private val repository: InfoRepository) : InfoInteractor {
        override fun info() = repository.info()
    }
}