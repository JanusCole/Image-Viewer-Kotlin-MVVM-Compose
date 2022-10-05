package com.januscole.kotlinscratchpad.data.source.searches.repository

import com.januscole.kotlinscratchpad.SavedSearches
import kotlinx.coroutines.flow.Flow

interface SearchCriteriaDatastoreRepository {
    suspend fun addSearch(searchCriteria: String)
    suspend fun clearSearches()
    // Was having a conversation with a colleague regarding functions vs vals in Kotlin and so tried this
    val savedSavedSearches: Flow<SavedSearches>
}