package com.example.newsapp

import com.example.newsapp.data.cloud.HandelDataRequest
import com.example.newsapp.data.models.NewsApiResponce
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testNews() = runBlocking {
        val repo = mockk<HandelDataRequest>()
        val block = createMockedBlock()



    }


    private fun createMockedBlock(): suspend () -> NewsApiResponce{
        return mockk()
    }


}