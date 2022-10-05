package com.januscole.kotlinscratchpad.data.source.searches.repository

import android.util.Log
import androidx.datastore.core.DataStore
import com.januscole.kotlinscratchpad.SavedSearches
import com.januscole.kotlinscratchpad.data.source.searches.model.BoundedQueue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException

class SavedSearchesLocalRepository (private val savedSearchesStore: DataStore<SavedSearches>): SearchCriteriaDatastoreRepository {

    private val recentSearches = BoundedQueue<String>(5)

    // Was having a conversation with a colleague regarding functions vs vals in Kotlin and so tried this
    override val savedSavedSearches: Flow<SavedSearches> = savedSearchesStore.data
        .catch { exception ->
            // dataStore.data throws an IOException when an error is encountered when reading data
            if (exception is IOException) {
                Log.e("DATASTORE ERROR", "Error reading saved searches preferences.", exception)
                emit(SavedSearches.getDefaultInstance())
            } else {
                throw exception
            }
        }

    override suspend fun addSearch(searchCriteria: String) {
        recentSearches.add(searchCriteria)
        updateSavedSearches(recentSearches)
    }

    suspend fun updateSavedSearches(savedCriteria: BoundedQueue<String>) {
        try {
            savedSearchesStore.updateData { savedSearches ->
                savedSearches.toBuilder().clearSearchCriteria().build()
            }
        } catch (e: Exception) {
        }
        try {
            savedSearchesStore.updateData { savedSearches ->
                savedSearches.toBuilder().addAllSearchCriteria(savedCriteria).build()
            }
        } catch (e: Exception) {
        }
    }

    override suspend fun clearSearches() {
        try {
            savedSearchesStore.updateData { savedSearches ->
                savedSearches.toBuilder().clearSearchCriteria().build()
            }
        } catch (e: Exception) {
        }
    }
}