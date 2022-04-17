package com.example.cleanarchitectureapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitectureapp.domain.InfoInteractor

class SharedViewModel(): ViewModel() {
    val text = MutableLiveData("")

}