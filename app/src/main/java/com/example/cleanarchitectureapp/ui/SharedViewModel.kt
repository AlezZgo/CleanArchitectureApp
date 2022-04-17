package com.example.cleanarchitectureapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitectureapp.data.InfoRepository
import com.example.cleanarchitectureapp.domain.InfoDomain
import com.example.cleanarchitectureapp.domain.InfoInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel() : ViewModel() {
    private val interactor = InfoInteractor.Base(InfoRepository.TestSuccess())
    private val dispatcher = Dispatcher.Base()
    val liveData = MutableLiveData<InfoDomain>()

    fun load() {
        dispatcher.apply {
            doBackground(viewModelScope){
                val result = interactor.info()
                doUi(viewModelScope){
                    liveData.value = result
                }
            }
        }
    }

}