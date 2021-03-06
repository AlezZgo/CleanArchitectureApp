package com.example.cleanarchitectureapp.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

interface Dispatcher  {

    fun doUi(scope: CoroutineScope, block: suspend () -> Unit)

    fun doBackground(scope: CoroutineScope,block: suspend () -> Unit)

    class Base : Dispatcher {

        override fun doBackground(scope: CoroutineScope,block: suspend () -> Unit) {
            scope.launch(Dispatchers.IO) {
                block.invoke()
            }
        }

        override fun doUi(scope: CoroutineScope,block: suspend () -> Unit) {
            scope.launch(Dispatchers.Main) {
                block.invoke()
            }
        }

    }
}