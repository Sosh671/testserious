package com.soshdevelopment.stocksapp.data.datasource

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.soshdevelopment.stocksapp.data.model.FavouriteStockModel

private const val FAVOURITE_STOCK_KEY = "favourite_stock"

class FavouriteStocksDataSourceImpl(
    private val preferences: SharedPreferences,
    private val gson: Gson
) : FavouriteStocksDataSource {

    override suspend fun addFavouriteStock(stockModel: FavouriteStockModel) {
        val type = object : TypeToken<FavouriteStockModel>() {}.type
        val favouritesList = getFavouriteStocks() as ArrayList
        favouritesList.add(stockModel)
        val json = gson.toJson(favouritesList, type)

        preferences.edit().putString(FAVOURITE_STOCK_KEY, json).apply()
    }

    override suspend fun removeFavouriteStock(stockModel: FavouriteStockModel) {
            val type = object : TypeToken<FavouriteStockModel>() {}.type
            val favouritesList = getFavouriteStocks() as ArrayList
            favouritesList.remove(stockModel)
            val json = gson.toJson(favouritesList, type)

            preferences.edit().putString(FAVOURITE_STOCK_KEY, json).apply()
    }

    override suspend fun getFavouriteStocks(): List<FavouriteStockModel> {
        val json = preferences.getString(FAVOURITE_STOCK_KEY, null) ?: return emptyList()
        val type = object : TypeToken<FavouriteStockModel>() {}.type
        return gson.fromJson(json, type)
    }
}