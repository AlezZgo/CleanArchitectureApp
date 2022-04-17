package com.example.cleanarchitectureapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitectureapp.data.InfoRepository
import com.example.cleanarchitectureapp.domain.InfoDomain
import com.example.cleanarchitectureapp.domain.InfoInteractor

class SharedViewModel(): ViewModel() {
    private val interactor = InfoInteractor.Base(InfoRepository.TestSuccess())
    val liveData = MutableLiveData<InfoDomain>()

    fun load(){
        liveData.value = interactor.info()
    }

}