package com.soshdevelopment.stocksapp.data.di

import android.content.Context
import android.content.SharedPreferences
import com.soshdevelopment.stocksapp.data.datasource.FavouriteStocksDataSource
import com.soshdevelopment.stocksapp.data.datasource.FavouriteStocksDataSourceImpl
import com.soshdevelopment.stocksapp.data.datasource.StocksDataSource
import com.soshdevelopment.stocksapp.data.datasource.StocksDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val PREFERENCES_NAME = "stocks_preferences"

val dataSourceModule = module {
    single<SharedPreferences> {
        androidContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
    single<FavouriteStocksDataSource> {
        FavouriteStocksDataSourceImpl(
            preferences = get(),
        )
    }
    single<StocksDataSource> {
        StocksDataSourceImpl(
            assets = androidContext().assets
        )
    }
}
