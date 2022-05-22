package com.soshdevelopment.stocksapp.data.repository

import com.soshdevelopment.stocksapp.data.model.FavouriteStockModel

interface FavouriteStocksRepository {

    suspend fun addFavouriteStock(stockModel: FavouriteStockModel)
    suspend fun removeFavouriteStock(stockModel: FavouriteStockModel)
    suspend fun getFavouriteStocks(): List<FavouriteStockModel>
}