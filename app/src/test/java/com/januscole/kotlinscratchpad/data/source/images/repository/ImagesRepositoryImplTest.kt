package com.januscole.kotlinscratchpad.data.source.images.repository

import com.januscole.fragmentviewmodel.model.ImageItem
//import com.januscole.fragmentviewmodel.service.RemoteImageService
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.util.concurrent.CountDownLatch

class ImagesRepositoryImplTest {

    // lateinit var imagesRepository : ImagesRepositoryImpl

    @Before
    fun setUp() {
        //imagesRepository = ImagesRepositoryImpl(RemoteImageService("https://api.flickr.com/services/feeds/"))
    }

    @Test
    fun searchImages() {
        // TODO Decouple this from the internet
        val countDownLatch = CountDownLatch(1)
/*
        imagesRepository.searchImages("cat", object : ImagesRepository.SearchImagesCallback{
            override fun onImagesLoaded(images: List<ImageItem>?) {
                images?.forEach {
                    println("Flikr Result " + it.title + " " + it.link)
                }
                assertEquals(20, images?.size)
                countDownLatch.countDown()
            }

            override fun onDataNotAvailable() {
                println("Image Search Failure")
                countDownLatch.countDown()
            }
        })
*/
        countDownLatch.await()
    }

    @Test
    fun fetchImage() {
        // TODO Decouple this from the internet
        val countDownLatch = CountDownLatch(1)
/*
        imagesRepository.searchImages("cat", object : ImagesRepository.SearchImagesCallback{
            override fun onImagesLoaded(images: List<ImageItem>?) {
                images?.forEach {
                    println("Flikr Results " + it.title + " " + it.link)
                }
                val testImage = images!![0]
                imagesRepository.fetchImage(testImage.link!!, object: ImagesRepository.FetchImageCallback{
                    override fun onImageLoaded(image: ImageItem?) {
                        println("Fetch First Image Result " + image?.title + " " + image?.link)
                        assertEquals(testImage, image)
                        countDownLatch.countDown()
                    }

                    override fun onDataNotAvailable() {
                        println("Image Fetch Failure")
                        countDownLatch.countDown()
                    }
                })
            }
*/

/*            override fun onDataNotAvailable() {
                println("Image Search Failure")
                countDownLatch.countDown()
            }
        })*/
        countDownLatch.await()
    }

    @Test
    fun getCache() {
/*        imagesRepository.imageCache = mutableListOf(ImageItem(link = "TestLink1"), ImageItem(link = "TestLink2"), ImageItem(link = "TestLink3"))
        assertEquals(3, imagesRepository.imageCache.size)
        assertEquals("TestLink1", imagesRepository.imageCache[0].link)*/
    }
}