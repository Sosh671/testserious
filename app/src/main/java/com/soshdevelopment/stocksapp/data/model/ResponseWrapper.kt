package com.soshdevelopment.stocksapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseWrapper(
    val content: StocksListWrapper,
    val status: String
)
