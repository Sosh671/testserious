package com.soshdevelopment.stocksapp.data.datasource

import com.soshdevelopment.stocksapp.data.model.StockModel

interface StocksDataSource {

    fun getStocksList(): List<StockModel>
}