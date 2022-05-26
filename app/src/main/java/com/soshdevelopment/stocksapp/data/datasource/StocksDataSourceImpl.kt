package com.soshdevelopment.stocksapp.data.datasource

import android.content.res.AssetManager
import com.soshdevelopment.stocksapp.data.model.ResponseWrapper
import com.soshdevelopment.stocksapp.data.model.StockModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import timber.log.Timber

class StocksDataSourceImpl(private val assets: AssetManager) : StocksDataSource {

    private val json = Json { ignoreUnknownKeys = true }

    override suspend fun getStocksListWeekly(): List<StockModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getStocksListMonthly(): List<StockModel> = withContext(Dispatchers.IO) {
        try {
            val stream = assets.open("month.txt")
            val item = json.decodeFromStream<ResponseWrapper>(stream)
            stream.close()
            item.content.quoteSymbols
        } catch (e: Exception) {
            Timber.e(e)
            emptyList()
        }
    }
}