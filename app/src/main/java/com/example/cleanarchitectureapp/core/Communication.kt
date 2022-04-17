package com.example.cleanarchitectureapp.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * @author Asatryan on 12.07.2021
 **/
interface Communication<T>  {

    fun observe(owner: LifecycleOwner, observer: Observer<T>)

    fun postValue(value: T)

    abstract class Base<T : Any> : Communication<T> {
        protected val liveData = MutableLiveData<T>()

        override fun observe(owner: LifecycleOwner, observer: Observer<T>) =
            liveData.observe(owner, observer)

        override fun postValue(value: T) {
            liveData.value = value
        }

    }
}