package com.januscole.kotlinscratchpad.ui.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.januscole.fragmentviewmodel.model.ImageItem
import com.januscole.kotlinscratchpad.data.source.images.repository.RetrofitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val retrofitRepository: RetrofitRepository): ViewModel() {
    private val image: MutableState<ImageItem> = mutableStateOf(ImageItem())

    fun getImage() : State<ImageItem> = image

    fun fetchImage(link: String) {
        image.value = retrofitRepository.fetchImage(link)!!
    }
}