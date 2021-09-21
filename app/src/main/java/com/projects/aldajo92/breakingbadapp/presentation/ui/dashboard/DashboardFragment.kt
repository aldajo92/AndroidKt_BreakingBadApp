package com.projects.aldajo92.breakingbadapp.presentation.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.projects.aldajo92.breakingbadapp.PAGINATION_AMOUNT
import com.projects.aldajo92.breakingbadapp.R
import com.projects.aldajo92.breakingbadapp.databinding.FragmentDashboardBinding
import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.presentation.adapter.GenericAdapter
import com.projects.aldajo92.breakingbadapp.presentation.adapter.GenericItem
import com.projects.aldajo92.breakingbadapp.presentation.adapter.ItemListener
import com.projects.aldajo92.breakingbadapp.presentation.adapter.PaginationScrollListener
import com.projects.aldajo92.breakingbadapp.presentation.events.DashBoardEvents
import com.projects.aldajo92.breakingbadapp.presentation.ui.BaseFragment
import com.projects.aldajo92.breakingbadapp.presentation.ui.dashboard.adapter.RecyclerBBItem
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DashboardFragment : BaseFragment(), ItemListener<BBCharacter> {

    @Inject
    lateinit var viewModel: DashBoardViewModel

    private lateinit var binding: FragmentDashboardBinding

    private lateinit var adapterCharacters: GenericAdapter<BBCharacter>

    private lateinit var gridLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater)
        adapterCharacters = GenericAdapter(this)
        gridLayoutManager = LinearLayoutManager(activity)

        binding.recyclerViewCharacters.apply {
            layoutManager = gridLayoutManager
            adapter = adapterCharacters
        }
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showToolbarTitle(R.string.dashboard_title, false)

        showLoader(true)
        handleCharacters(viewModel.characterItems)

        binding.recyclerViewCharacters.addOnScrollListener(
            object : PaginationScrollListener(gridLayoutManager, PAGINATION_AMOUNT) {
                override fun onLoadMore(currentPage: Int, totalItemCount: Int) {
                    viewModel.getProductsByPagination(totalItemCount)
                }
            }
        )

        viewModel.responseLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is DashBoardEvents.ProductsSuccess -> handleCharacters(it.getDataOnce())
                is DashBoardEvents.ProductsPaginationSuccess -> handlePaginationResponse(it.getDataOnce())
                is DashBoardEvents.ErrorMessage -> Unit // TODO: add error message
                else -> Unit
            }
        })
    }

    private fun handleCharacters(characters: List<BBCharacter>?) {
        showLoader(false)
        characters?.map {
            RecyclerBBItem(it, R.layout.item_dashboard)
        }?.let {
            adapterCharacters.updateData(it)
        }
    }

    private fun handlePaginationResponse(productModels: List<BBCharacter>?) {
        showLoader(false)
        productModels?.map {
            RecyclerBBItem(it, R.layout.item_dashboard)
        }?.let {
            adapterCharacters.updateData(it)
        }
    }

    override fun onClickItem(item: GenericItem<BBCharacter>) {
        val action = DashboardFragmentDirections.actionDashboardFragmentToDetailFragment(item.data)
        findNavController().navigate(action)
    }

    override fun onFavoriteClicked(item: GenericItem<BBCharacter>) {
        if (item is RecyclerBBItem){
            val state = !(item.favoriteStatusField.get() ?: false)
            viewModel.toggleFavorites(item.character, state)
            item.favoriteStatusField.set(state)
        }
    }
}