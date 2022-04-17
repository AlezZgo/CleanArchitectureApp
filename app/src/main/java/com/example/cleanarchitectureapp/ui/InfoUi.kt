package com.example.cleanarchitectureapp.ui

import android.widget.ImageView
import android.widget.TextView
import com.example.cleanarchitectureapp.R
import com.example.cleanarchitectureapp.domain.InfoDomain

sealed class InfoUi {

    abstract fun show(image: ImageView,text: TextView) : Unit

    data class Success(
        private val infoText: String
    ): InfoUi() {
        override fun show(image: ImageView, text: TextView) {
            image.setImageResource(R.drawable.success1)
        }

    }

    data class Failure(
        private val errorMessage: String,
    ): InfoUi() {
        override fun show(image: ImageView, text: TextView) {
            image.setImageResource(R.drawable.fail1)
        }
    }


}
