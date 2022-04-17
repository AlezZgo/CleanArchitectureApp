package com.example.cleanarchitectureapp.ui

import android.widget.ImageView
import android.widget.TextView
import com.example.cleanarchitectureapp.R

sealed class InfoUi {

    abstract fun show(image: ImageView, textView: TextView): Unit

    data class Success(
        private val infoText: String,
    ) : InfoUi() {
        override fun show(image: ImageView, textView: TextView) {
            image.setImageResource(R.drawable.success1)
            textView.text = infoText
        }

    }

    data class Failure(
        private val errorMessage: String,
    ) : InfoUi() {
        override fun show(image: ImageView, textView: TextView) {
            image.setImageResource(R.drawable.fail1)
            textView.text = errorMessage
        }
    }

    object Loading : InfoUi() {
        override fun show(image: ImageView, textView: TextView) {
            image.setImageResource(R.drawable.wait1)
            textView.text = "Loading..."
        }

    }


}
