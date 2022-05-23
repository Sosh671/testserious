package com.soshdevelopment.stocksapp.domain.di

import com.soshdevelopment.stocksapp.domain.usecase.GetStocksListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetStocksListUseCase(repository = get())
    }
}