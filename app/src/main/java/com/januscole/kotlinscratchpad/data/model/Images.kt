package com.januscole.fragmentviewmodel.model

import com.google.gson.annotations.SerializedName

data class ImageItem (
    val title: String? = null,
    val link: String? = null,
    @SerializedName("media")
    val imageLocation: ImageLocation? = null,
    val date_taken: String? = null,
    val description: String? = null,
    val published: String? = null,
    val author: String? = null,
    val author_id: String? = null,
    val tags: String? = null
)

data class ImageLocation (
    @SerializedName("m")
    var imageURL: String? = null
)

data class ImageSearchResults (
    var title: String? = null,
    var link: String? = null,
    var description: String? = null,
    var modified: String? = null,
    var generator: String? = null,
    var items: List<ImageItem>? = null
)
