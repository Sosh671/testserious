package com.soshdevelopment.stocksapp.domain.usecase

import com.soshdevelopment.stocksapp.data.model.StockModel
import com.soshdevelopment.stocksapp.data.repository.StocksRepository

class GetStocksListUseCase(
    private val repository: StocksRepository
): BaseUseCase<List<StockModel>> {

    override suspend fun invoke(): List<StockModel> {
        return repository.getStocksList()
    }
}