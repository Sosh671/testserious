package com.soshdevelopment.stocksapp.data.repository

import com.soshdevelopment.stocksapp.data.model.FavouriteStockModel

interface FavouriteStocksRepository {

    fun addFavouriteStock(stockModel: FavouriteStockModel)
    fun removeFavouriteStock(stockModel: FavouriteStockModel)
    fun getFavouriteStocks(): List<FavouriteStockModel>
}