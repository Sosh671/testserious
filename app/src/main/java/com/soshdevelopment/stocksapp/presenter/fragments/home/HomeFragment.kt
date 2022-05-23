package com.soshdevelopment.stocksapp.presenter.fragments.home

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.soshdevelopment.stocksapp.R
import com.soshdevelopment.stocksapp.databinding.FragmentHomeBinding
import com.soshdevelopment.stocksapp.presenter.fragments.base.BaseFragment

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabAddStock.setOnClickListener {
            navigateTo(HomeFragmentDirections.toAddFavouriteStockFragment())
        }
    }
}