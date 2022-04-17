package com.example.cleanarchitectureapp.domain

import com.example.cleanarchitectureapp.ui.InfoUi

sealed class InfoDomain {

    abstract fun toUi(): InfoUi

    data class Success(
        private val first: String,
        private val second: String,
    ) : InfoDomain() {
        override fun toUi() = InfoUi.Success("$first $second")
    }

    data class Failure(
        private val errorMessage: String,
    ) : InfoDomain() {
        override fun toUi() = InfoUi.Failure(errorMessage)
    }
}
