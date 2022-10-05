package com.januscole.kotlinscratchpad.data.source.images.service

import com.januscole.fragmentviewmodel.model.ImageSearchResults
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("photos_public.gne")
    suspend fun searchImages(@Query("tags") searchCriteria: String,
                     @Query("format") resultFormat: String = "json",
                     @Query("nojsoncallback") callback: String = "1"): ImageSearchResults
}