package com.soshdevelopment.stocksapp.domain.usecase

interface BaseUseCase<Response> {
    suspend fun invoke(): Response
}