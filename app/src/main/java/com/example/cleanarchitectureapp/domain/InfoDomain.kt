package com.example.cleanarchitectureapp.domain

sealed class InfoDomain {

    data class Success(
        private val first: String,
        private val second: String,
    ): InfoDomain()

    data class Failure(
        private val errorMessage: String,
    ): InfoDomain()

}
