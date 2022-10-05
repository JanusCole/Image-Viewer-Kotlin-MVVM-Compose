package com.januscole.kotlinscratchpad.data.source.images.service

import com.januscole.fragmentviewmodel.model.ImageItem
//import com.januscole.fragmentviewmodel.service.ImageService
//import com.januscole.fragmentviewmodel.service.RemoteImageService
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.util.concurrent.CountDownLatch

class RemoteImageServiceTest {

    //val imageService = RemoteImageService("https://api.flickr.com/services/feeds/")

    @Before
    fun setUp() {
    }

    @Test
    fun searchImages() {
        // TODO Decouple this from the internet
        val countDownLatch = CountDownLatch(1)
/*        imageService.searchImages("cat", object : ImageService.SearchImagesCallback{
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
        })*/
        countDownLatch.await()
    }
}