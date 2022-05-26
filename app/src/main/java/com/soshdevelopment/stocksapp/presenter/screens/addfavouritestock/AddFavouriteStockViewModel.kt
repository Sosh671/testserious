package com.soshdevelopment.stocksapp.presenter.screens.addfavouritestock

import androidx.lifecycle.viewModelScope
import com.soshdevelopment.stocksapp.data.model.StockModel
import com.soshdevelopment.stocksapp.domain.usecase.GetStocksListUseCase
import com.soshdevelopment.stocksapp.presenter.screens.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AddFavouriteStockViewModel(
    private val getStocksListUseCase: GetStocksListUseCase
) : BaseViewModel() {

    private val _stocksList = MutableStateFlow(listOf<StockModel>())
    val stocksList = _stocksList as StateFlow<List<StockModel>>

    init {
        viewModelScope.launch {
            // todo this is not a working solution since it will show already saved to favourites stocks
            // todo so favourite stocks should be excluded from the list of all stocks
            _stocksList.value = getStocksListUseCase.invoke()
        }
    }
}