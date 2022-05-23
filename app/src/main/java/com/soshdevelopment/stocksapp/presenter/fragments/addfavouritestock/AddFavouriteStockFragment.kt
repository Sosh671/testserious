package com.soshdevelopment.stocksapp.presenter.fragments.addfavouritestock

import by.kirich1409.viewbindingdelegate.viewBinding
import com.soshdevelopment.stocksapp.R
import com.soshdevelopment.stocksapp.databinding.FragmentAddFavouriteStockBinding
import com.soshdevelopment.stocksapp.presenter.fragments.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddFavouriteStockFragment : BaseFragment(R.layout.fragment_add_favourite_stock) {

    private val binding: FragmentAddFavouriteStockBinding by viewBinding()
    private val viewModel: AddFavouriteStockViewModel by viewModel()
}