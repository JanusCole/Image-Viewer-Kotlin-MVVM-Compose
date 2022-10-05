package com.januscole.kotlinscratchpad.data.source.images.repository

import com.januscole.fragmentviewmodel.model.ImageItem
import com.januscole.fragmentviewmodel.model.ImageSearchResults
import com.januscole.kotlinscratchpad.data.source.images.service.RetrofitService
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.*
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RetrofitRepositoryImplTest {

    @Mock
    lateinit var retrofitService: RetrofitService

    @Before
    fun setUp() {
    }

    @Test
    fun `test the fetchImage function`() {
        val testRepository = RetrofitRepositoryImpl(retrofitService)
        testRepository.imageCache = mutableListOf(ImageItem(link = "TestLink1"), ImageItem(link = "TestLink2"), ImageItem(link = "TestLink3"))
        assertEquals("TestLink1", testRepository.fetchImage("TestLink1")?.link)
    }

    @Test
    fun `test the searchImages function`() = runBlocking {
        val testImageSearchResult = ImageSearchResults(items = mutableListOf(ImageItem(link = "TestLink1"), ImageItem(link = "TestLink2"), ImageItem(link = "TestLink3")))
        `when` (retrofitService.searchImages(anyString())).thenReturn(testImageSearchResult)
        val testRepository = RetrofitRepositoryImpl(retrofitService)
        testRepository.searchImages("")
        assertEquals("TestLink1", testRepository.fetchImage("TestLink1")?.link)
    }

    @Test
    fun `test the fetchCache function` () {
        val testRepository = RetrofitRepositoryImpl(retrofitService)
        testRepository.imageCache = mutableListOf(ImageItem(link = "TestLink1"), ImageItem(link = "TestLink2"), ImageItem(link = "TestLink3"))
        assertEquals(3, testRepository.fetchCache().size)
        assertEquals("TestLink1", testRepository.fetchCache()[0].link)
    }
}