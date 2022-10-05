package com.januscole.kotlinscratchpad.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import coil.compose.AsyncImage
import com.januscole.fragmentviewmodel.model.ImageItem
import com.januscole.kotlinscratchpad.R
import com.januscole.kotlinscratchpad.ui.search.SearchFragmentDirections
import com.januscole.kotlinscratchpad.ui.search.SearchViewModel

@Composable
    fun ImageSearchScreen(fragment: Fragment) {
    val viewModel: SearchViewModel = viewModel()

        var searchCriteria by remember { mutableStateOf("") }
        val imageList by remember {viewModel.getImages()}
        val savedSearches by remember {viewModel.getRecentSearches()}
        val searchButtonText by remember {viewModel.getSearchButtonText()}

        Column() {
            Row {
                TextField(
                    value = searchCriteria,
                    onValueChange = {searchCriteria = it},
                    maxLines = 1,
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(id = R.dimen.standard_padding_size_5dp))
                        .fillMaxWidth()
                        .wrapContentHeight(Alignment.CenterVertically)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    singleLine = true,
                    trailingIcon = {
                        Icon(Icons.Filled.Search,
                            contentDescription = stringResource(id = R.string.search_text_accessibility_hint),
                            tint = Color.Black)
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White
                    )
                )
            }
            Button(onClick = {
                viewModel.searchImages(searchCriteria)
            },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = searchButtonText),
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
            Text(
                text = stringResource(id = R.string.recent_searches_label),
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            Column {
                savedSearches.forEachIndexed { index, s ->
                        Button(
                            onClick = {
                                viewModel.searchImages(index)
                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .clickable(
                                    onClickLabel = stringResource(R.string.search_button_accessibility_hint)
                                ) {
                                    viewModel.searchImages(index)
                                }
                        ) {
                            Text(
                                text = s,
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            )
                        }
                    }

            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 2)
            ) {
                items(imageList) { image ->
                    ImageCard(image, fragment)
                }
            }
        }
}

@Composable
fun ImageCard(image: ImageItem, fragment: Fragment) {
    Column(
        modifier = Modifier.clickable (
            onClickLabel = stringResource(R.string.image_button_accessibility_hint)
        ) {
            val action = SearchFragmentDirections.actionGoToDetailFragment(image.link!!)
            findNavController(fragment).navigate(action)
        }
    ) {
        AsyncImage(
            model = image.imageLocation?.imageURL,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = image.title!!,
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.standard_padding_size_5dp))
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}
