package com.soshdevelopment.stocksapp.presenter.di

import com.soshdevelopment.stocksapp.presenter.fragments.addfavouritestock.AddFavouriteStockViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        AddFavouriteStockViewModel(getStocksListUseCase = get())
    }
}