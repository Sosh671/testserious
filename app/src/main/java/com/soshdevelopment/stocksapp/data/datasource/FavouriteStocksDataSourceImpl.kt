package com.soshdevelopment.stocksapp.data.datasource

import android.content.SharedPreferences
import com.soshdevelopment.stocksapp.data.model.FavouriteStockModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val FAVOURITE_STOCK_KEY = "favourite_stock"

class FavouriteStocksDataSourceImpl(
    private val preferences: SharedPreferences,
) : FavouriteStocksDataSource {

    private val json = Json { }

    override suspend fun addFavouriteStock(stockModel: FavouriteStockModel) {
        val favouritesList = getFavouriteStocks() as ArrayList
        favouritesList.add(stockModel)
        val json = json.encodeToString(favouritesList)

        preferences.edit().putString(FAVOURITE_STOCK_KEY, json).apply()
    }

    override suspend fun removeFavouriteStock(stockModel: FavouriteStockModel) {
        val favouritesList = getFavouriteStocks() as ArrayList
        favouritesList.remove(stockModel)
        val json = json.encodeToString(favouritesList)

        preferences.edit().putString(FAVOURITE_STOCK_KEY, json).apply()
    }

    override suspend fun getFavouriteStocks(): List<FavouriteStockModel> {
        val string = preferences.getString(FAVOURITE_STOCK_KEY, null) ?: return emptyList()
        return json.decodeFromString(string)
    }
}