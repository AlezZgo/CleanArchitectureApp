package com.example.cleanarchitectureapp.core

import junit.framework.Assert.assertTrue
import org.junit.Test
import java.io.IOException
import java.lang.Exception

class AbstractTest{

    @Test
    fun `test success`(){
        val dataObject = TestDataObject.Success("a","b")

        val domainObject = dataObject.map(DataToDomainMapper.Base())

        assertTrue(domainObject is TestDomainObject.Success)
    }

    private sealed class TestDataObject: Abstract.Object<TestDomainObject, DataToDomainMapper> {
        abstract override fun map(mapper: DataToDomainMapper): TestDomainObject

        class Success(private val textOne: String,private val textTwo: String): TestDataObject(){
            override fun map(mapper: DataToDomainMapper): TestDomainObject {
                return mapper.map(textOne, textTwo)
            }

        }

        class Fail(private val e: Exception): TestDataObject(){
            override fun map(mapper: DataToDomainMapper): TestDomainObject {
                return mapper.map(e)
            }

        }
    }

    private interface DataToDomainMapper: Abstract.Mapper{

        fun map(textOne: String,textTwo: String) : TestDomainObject

        fun map(e: Exception) : TestDomainObject

        class Base: DataToDomainMapper{
            override fun map(textOne: String, textTwo: String): TestDomainObject {
                return TestDomainObject.Success("$textOne $textTwo")
            }

            override fun map(e: Exception): TestDomainObject {
                return TestDomainObject.Fail()
            }

        }

    }

    private sealed class TestDomainObject : Abstract.Object<TestUiObject,DomainToUiMapper>{
        class Success(private val textCombined: String) : TestDomainObject(){
            override fun map(mapper: DomainToUiMapper): TestUiObject {
                TODO()
            }

        }

        class Fail : TestDomainObject() {
            override fun map(mapper: DomainToUiMapper): TestUiObject {
                TODO()
            }

        }
    }

    private interface DomainToUiMapper: Abstract.Mapper

    private sealed class TestUiObject

}