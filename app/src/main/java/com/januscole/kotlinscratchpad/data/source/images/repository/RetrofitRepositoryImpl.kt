package com.januscole.kotlinscratchpad.data.source.images.repository

import com.januscole.fragmentviewmodel.model.ImageItem
import com.januscole.fragmentviewmodel.model.ImageSearchResults
import com.januscole.kotlinscratchpad.data.source.images.service.RetrofitService
import javax.inject.Inject

class RetrofitRepositoryImpl @Inject constructor(private val retrofitService: RetrofitService): RetrofitRepository {

    // internal for testing
    internal var imageCache: MutableList<ImageItem> = mutableListOf()

    override fun fetchImage(imageLink: String): ImageItem? {
        return imageCache.filter{it.link == imageLink}.firstOrNull()
    }

    override suspend fun searchImages(searchCriteria: String): List<ImageItem> {
        val imageSearchResults: ImageSearchResults = retrofitService.searchImages(searchCriteria)
        imageCache.clear()
        imageCache.addAll(imageSearchResults.items!!)
        return imageSearchResults.items!!
    }

    override fun fetchCache(): List<ImageItem> {
        return imageCache
    }
}