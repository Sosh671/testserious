package com.soshdevelopment.stocksapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class StocksListWrapper(
    val quoteSymbols: List<StockModel>
)
