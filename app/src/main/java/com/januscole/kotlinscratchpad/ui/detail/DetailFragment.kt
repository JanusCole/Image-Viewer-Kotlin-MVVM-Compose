package com.januscole.kotlinscratchpad.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.accompanist.appcompattheme.AppCompatTheme
import com.januscole.kotlinscratchpad.composables.ImageDetailScreen
import com.januscole.kotlinscratchpad.databinding.DetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }
    private var _binding: DetailFragmentBinding? = null

    private val binding get() = _binding!!

    private val detailViewModel: DetailViewModel by viewModels()

    val args : DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailFragmentBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageLink =  args.link

        binding.viewModel = detailViewModel
        binding.lifecycleOwner = this

        binding.imageText.setContent {
            AppCompatTheme {
                ImageDetailScreen(this)
            }
        }
        detailViewModel.fetchImage(imageLink)
    }
}