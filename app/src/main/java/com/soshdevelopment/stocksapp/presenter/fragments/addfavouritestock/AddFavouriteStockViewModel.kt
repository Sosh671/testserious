package com.soshdevelopment.stocksapp.presenter.fragments.addfavouritestock

import com.soshdevelopment.stocksapp.domain.usecase.GetStocksListUseCase
import com.soshdevelopment.stocksapp.presenter.fragments.base.BaseViewModel

class AddFavouriteStockViewModel(
    private val getStocksListUseCase: GetStocksListUseCase
): BaseViewModel() {
}