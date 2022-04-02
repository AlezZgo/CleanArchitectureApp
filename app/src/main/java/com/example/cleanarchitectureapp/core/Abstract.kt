package com.example.cleanarchitectureapp.core

interface Abstract {

    interface Object<T,M: Mapper>{
        fun map(mapper: M): T
    }

    interface Mapper{
        class Empty: Mapper
    }
}