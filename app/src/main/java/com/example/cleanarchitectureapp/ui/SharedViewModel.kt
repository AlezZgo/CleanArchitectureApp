package com.example.cleanarchitectureapp.ui

import com.example.cleanarchitectureapp.core.BaseViewModel
import com.example.cleanarchitectureapp.core.Dispatcher
import com.example.cleanarchitectureapp.data.InfoRepository
import com.example.cleanarchitectureapp.domain.InfoInteractor

class SharedViewModel : BaseViewModel<InfoUi>(
    InfoCommunication(),
    Dispatcher.Base()
) {
    private val interactor = InfoInteractor.Base(InfoRepository.TestFailure())

    fun load() {
        communication.postValue(InfoUi.Loading)
        handle(
            {
                interactor.info()
            },
            { result ->
                communication.postValue(result.toUi())
            }
        )

    }
}

