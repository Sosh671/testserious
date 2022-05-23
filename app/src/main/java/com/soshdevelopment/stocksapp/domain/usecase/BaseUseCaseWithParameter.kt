package com.soshdevelopment.stocksapp.domain.usecase

interface BaseUseCaseWithParameter<Parameter, Response> {
    suspend fun invoke(param: Parameter): Response
}