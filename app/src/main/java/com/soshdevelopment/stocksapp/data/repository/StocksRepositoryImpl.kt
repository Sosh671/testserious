package com.soshdevelopment.stocksapp.data.repository

import com.soshdevelopment.stocksapp.data.datasource.StocksDataSource
import com.soshdevelopment.stocksapp.data.model.StockModel

class StocksRepositoryImpl(
    private val dataSource: StocksDataSource
) : StocksRepository {

    // based on the files contents I assume that weekly and monthly stocks coincide, so I can grab
    // either to display list of all the stocks available
    override suspend fun getStocksList(): List<StockModel> {
        return dataSource.getStocksListMonthly()
    }

    override suspend fun getStocksListWeekly(): List<StockModel> {
        return dataSource.getStocksListWeekly()
    }

    override suspend fun getStocksListMonthly(): List<StockModel> {
        return dataSource.getStocksListMonthly()
    }
}