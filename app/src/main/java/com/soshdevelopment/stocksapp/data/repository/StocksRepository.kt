package com.soshdevelopment.stocksapp.data.repository

import com.soshdevelopment.stocksapp.data.model.StockModel

interface StocksRepository {

    fun getStocksList(): List<StockModel>
}