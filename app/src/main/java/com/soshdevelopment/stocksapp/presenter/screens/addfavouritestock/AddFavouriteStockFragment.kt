package com.soshdevelopment.stocksapp.presenter.screens.addfavouritestock

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.soshdevelopment.stocksapp.R
import com.soshdevelopment.stocksapp.databinding.FragmentAddFavouriteStockBinding
import com.soshdevelopment.stocksapp.presenter.screens.addfavouritestock.adapter.AddFavouriteStockRecyclerViewAdapter
import com.soshdevelopment.stocksapp.presenter.screens.base.BaseFragment
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddFavouriteStockFragment : BaseFragment(R.layout.fragment_add_favourite_stock) {

    private val binding: FragmentAddFavouriteStockBinding by viewBinding()
    private val viewModel: AddFavouriteStockViewModel by viewModel()
    private val adapter = AddFavouriteStockRecyclerViewAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }

    private fun initViews() = with(binding) {
        rvStocks.run {
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@AddFavouriteStockFragment.adapter
        }
    }

    private fun initListeners() = with(lifecycleScope) {
        launchWhenCreated {
            viewModel.stocksList.collectLatest { adapter.submitList(it) }
        }
    }
}