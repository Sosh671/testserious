package com.soshdevelopment.stocksapp.data.repository

import com.soshdevelopment.stocksapp.data.model.StockModel

class StocksRepositoryImpl(
    private val dataSource: StocksDataSource
): StocksRepository {

    override suspend fun getStocksList(): List<StockModel> {
        return dataSource.getStocksList()
    }
}