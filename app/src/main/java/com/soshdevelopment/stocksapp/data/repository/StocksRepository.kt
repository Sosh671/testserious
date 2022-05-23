package com.soshdevelopment.stocksapp.data.repository

import com.soshdevelopment.stocksapp.data.model.StockModel

interface StocksRepository {

    suspend fun getStocksList(): List<StockModel>
    suspend fun getStocksListWeekly(): List<StockModel>
    suspend fun getStocksListMonthly(): List<StockModel>
}