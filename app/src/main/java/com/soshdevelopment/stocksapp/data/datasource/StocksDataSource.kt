package com.soshdevelopment.stocksapp.data.datasource

import com.soshdevelopment.stocksapp.data.model.StockModel

interface StocksDataSource {

    suspend fun getStocksListWeekly(): List<StockModel>
    suspend fun getStocksListMonthly(): List<StockModel>
}