package com.januscole.kotlinscratchpad.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.januscole.kotlinscratchpad.SavedSearches
import com.januscole.kotlinscratchpad.databinding.MainActivityBinding
import com.januscole.kotlinscratchpad.datastore.SavedSearchesSerializer
import dagger.hilt.android.AndroidEntryPoint

private const val DATA_STORE_FILE_NAME = "saved_searches.pb"

// Build the DataStore
private val Context.savedSearchesStore: DataStore<SavedSearches> by dataStore(
    fileName = DATA_STORE_FILE_NAME,
    serializer = SavedSearchesSerializer
)

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}