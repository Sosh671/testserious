package com.soshdevelopment.stocksapp.data.repository

import com.soshdevelopment.stocksapp.data.model.StockModel

interface StocksRepository {

    suspend fun getStocksList(): List<StockModel>
}