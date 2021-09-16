package com.projects.aldajo92.breakingbadapp.presentation.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.databinding.FragmentFirstBinding
import com.projects.aldajo92.breakingbadapp.presentation.BaseFragment
import com.projects.aldajo92.breakingbadapp.presentation.adapter.GenericAdapter
import com.projects.aldajo92.breakingbadapp.presentation.adapter.GenericItem
import com.projects.aldajo92.breakingbadapp.presentation.adapter.ItemListener
import timber.log.Timber
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DashboardFragment : BaseFragment(), ItemListener<BBCharacter> {

    @Inject
    lateinit var viewModel: DashBoardViewModel

    private lateinit var binding: FragmentFirstBinding

    private lateinit var adapterCharacters: GenericAdapter<BBCharacter>

    private lateinit var gridLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater)
        adapterCharacters = GenericAdapter(this)
        gridLayoutManager = LinearLayoutManager(activity)

        binding.recyclerViewCharacters.apply {
            layoutManager = gridLayoutManager
            adapter = adapterCharacters
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewCharacters
        val characters = viewModel.getCharacters()

        Timber.i("Hello")

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onClickItem(item: GenericItem<BBCharacter>) {

    }
}