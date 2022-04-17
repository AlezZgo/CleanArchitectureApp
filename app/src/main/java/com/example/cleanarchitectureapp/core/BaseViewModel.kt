package com.example.cleanarchitectureapp.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitectureapp.ui.InfoCommunication

abstract class BaseViewModel<T>(
    protected val communication: Communication<T> ,
    private val dispatcher: Dispatcher = Dispatcher.Base(),
) : ViewModel() {

    fun observe(owner: LifecycleOwner, observer: Observer<T>) =
        communication.observe(owner, observer)

    protected fun <T> handle(
        block: suspend () -> T,
        success: suspend (T) -> Unit,
    ) {
        dispatcher.apply {
            doBackground(viewModelScope) {
                val result = block.invoke()
                doUi(viewModelScope) {
                    success.invoke(result)
                }
            }
        }
    }

}