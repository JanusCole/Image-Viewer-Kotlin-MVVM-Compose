package com.januscole.kotlinscratchpad.data.source.images.repository

import com.januscole.fragmentviewmodel.model.ImageItem

interface RetrofitRepository {
    fun fetchImage(imageLink: String): ImageItem?
    suspend fun searchImages(searchCriteria: String): List<ImageItem>
    fun fetchCache(): List<ImageItem>
}