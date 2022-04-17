package com.example.cleanarchitectureapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    val score = MutableLiveData(0)


}