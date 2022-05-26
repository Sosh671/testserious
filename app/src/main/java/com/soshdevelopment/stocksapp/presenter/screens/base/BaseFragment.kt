package com.soshdevelopment.stocksapp.presenter.screens.base

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

open class BaseFragment(fragmentResId: Int) : Fragment(fragmentResId) {

    fun navigateTo(directions: NavDirections) {
        findNavController().navigate(directions)
    }
}