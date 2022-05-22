package com.soshdevelopment.stocksapp.data.datasource

import android.content.res.AssetManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.soshdevelopment.stocksapp.data.model.StockModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.BufferedReader

class StocksDataSourceImpl(
    private val gson: Gson,
    private val assets: AssetManager
) : StocksDataSource {

    override suspend fun getStocksListWeekly(): List<StockModel> = withContext(Dispatchers.IO) {
        try {
            val type = object : TypeToken<StockModel>() {}.type
            val fileReader = BufferedReader(assets.open("week.txt").reader())
            val jsonReader = JsonReader(fileReader)
            val list: List<StockModel> = gson.fromJson(jsonReader, type)
            jsonReader.close()
            fileReader.close()

            list
        } catch (e: Exception) {
            Timber.e(e)
            emptyList()
        }
    }


    override suspend fun getStocksListMonthly(): List<StockModel> {
        TODO("Not yet implemented")
    }
}