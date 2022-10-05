package com.januscole.kotlinscratchpad.ui.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.januscole.fragmentviewmodel.model.ImageItem
import com.januscole.kotlinscratchpad.R
import com.januscole.kotlinscratchpad.data.source.images.repository.RetrofitRepository
import com.januscole.kotlinscratchpad.data.source.searches.repository.SearchCriteriaDatastoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(val retrofitRepository: RetrofitRepository, val savedSearchesRepository: SearchCriteriaDatastoreRepository): ViewModel() {

    private val imageResults: MutableState<List<ImageItem>> = mutableStateOf(listOf())
    private val searchButtonText : MutableState<Int> = mutableStateOf(R.string.search)
    private val recentSearches : MutableState<List<String>> = mutableStateOf(listOf())

    fun getImages() = imageResults
    fun getSearchButtonText() = searchButtonText
    fun getRecentSearches() = recentSearches

    init {
        imageResults.value = retrofitRepository.fetchCache()
        viewModelScope.launch {
            savedSearchesRepository.clearSearches()
            savedSearchesRepository.savedSavedSearches.collect({
                recentSearches.value = it.searchCriteriaList
            })
        }
    }

    fun searchImages(searchCriteria: String) {
        searchButtonText.value = R.string.searching
        viewModelScope.launch (Dispatchers.IO) {
            try {
                imageResults.value = retrofitRepository.searchImages(searchCriteria)
                savedSearchesRepository.addSearch(searchCriteria)
                searchButtonText.value = R.string.search
            } catch (e : Exception) {
            } finally {
                withContext(Dispatchers.Main) {
                    searchButtonText.value = R.string.search
                }
            }
        }
    }

    fun searchImages(recentSearchCriteria: Int) {
        searchButtonText.value = R.string.searching
        viewModelScope.launch (Dispatchers.IO) {
            try {
                imageResults.value = retrofitRepository.searchImages(recentSearches.value.get(recentSearchCriteria))
                searchButtonText.value = R.string.search
            } catch (e : Exception) {
            } finally {
                searchButtonText.value = R.string.search
            }
        }
    }
}