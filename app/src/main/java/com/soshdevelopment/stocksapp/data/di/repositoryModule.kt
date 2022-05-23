package com.soshdevelopment.stocksapp.data.di

import com.soshdevelopment.stocksapp.data.repository.StocksRepository
import com.soshdevelopment.stocksapp.data.repository.StocksRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<StocksRepository>{
        StocksRepositoryImpl(dataSource = get())
    }
}