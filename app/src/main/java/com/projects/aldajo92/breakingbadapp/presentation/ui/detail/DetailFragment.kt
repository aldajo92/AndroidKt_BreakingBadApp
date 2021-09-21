package com.projects.aldajo92.breakingbadapp.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.projects.aldajo92.breakingbadapp.R
import com.projects.aldajo92.breakingbadapp.databinding.FragmentDetailBinding
import com.projects.aldajo92.breakingbadapp.presentation.ui.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: DetailViewModel

    private lateinit var binding: FragmentDetailBinding

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val character = args.character

        showToolbarTitle(character.nickName, true)

        binding.viewModel = viewModel
        viewModel.initInfo(character)

    }

}