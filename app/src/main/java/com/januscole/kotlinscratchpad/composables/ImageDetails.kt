package com.januscole.kotlinscratchpad.composables

import androidx.compose.runtime.Composable
import com.januscole.kotlinscratchpad.ui.detail.DetailViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import coil.compose.AsyncImage
import com.januscole.kotlinscratchpad.R

@Composable
    fun ImageDetailScreen(fragment: Fragment) {
        val imageViewModel: DetailViewModel = viewModel()
        Column() {
            Button(onClick = {
                findNavController(fragment).navigate(R.id.action_go_to_main_fragment)
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                        contentDescription = stringResource(id = R.string.back_button_accessibility_hint),
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier
                            .wrapContentWidth(Alignment.Start)
                            .align(
                                Alignment.CenterVertically
                            )
                    )
                    HeaderImageTitle()
                }
            }

            AsyncImage(
                model = imageViewModel.getImage().value.imageLocation?.imageURL,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
                Row() {
                    ImageTextLabel(R.string.image_title_label)
                    ImageTitle()
                }
                Row() {
                    ImageTextLabel(R.string.image_author_label)
                    ImageAuthor()
                }
                Row() {
                    ImageTextLabel(R.string.image_description_label)
                    ImageDescription()
                }
            }
    }

    @Composable
    private fun ImageTextLabel(textResourceId: Int) {
        Text(
            text = stringResource(id = textResourceId),
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.standard_padding_size_5dp))
                .wrapContentWidth(Alignment.Start)
        )
    }

    @Composable
    private fun HeaderImageTitle() {
        val imageViewModel: DetailViewModel = viewModel()
        Text(
            text = imageViewModel.getImage().value.title!!,
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }

@Composable
private fun ImageTitle() {
    val imageViewModel: DetailViewModel = viewModel()
    Text(
        text = imageViewModel.getImage().value.title!!,
        style = MaterialTheme.typography.body2,
        modifier = Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.standard_padding_size_5dp))
            .wrapContentWidth(Alignment.Start)
        )
    }

    @Composable
    private fun ImageAuthor() {
        val imageViewModel: DetailViewModel = viewModel()
        Text(
            text = imageViewModel.getImage().value.author ?: "",
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.standard_padding_size_5dp))
                .wrapContentWidth(Alignment.Start)
        )
    }

    @Composable
    private fun ImageDescription() {
        val imageViewModel: DetailViewModel = viewModel()
        Text(
            text = imageViewModel.getImage().value.tags!!,
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.standard_padding_size_5dp))
                .wrapContentWidth(Alignment.Start)
        )
    }
