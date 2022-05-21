package com.soshdevelopment.stocksapp.data.datasource

import com.soshdevelopment.stocksapp.data.model.FavouriteStockModel

interface FavouriteStocksDataSource {

    suspend fun addFavouriteStock(stockModel: FavouriteStockModel)
    suspend fun removeFavouriteStock(stockModel: FavouriteStockModel)
    suspend fun getFavouriteStocks(): List<FavouriteStockModel>
}