package com.soshdevelopment.stocksapp

import android.app.Application
import com.soshdevelopment.stocksapp.data.di.dataSourceModule
import com.soshdevelopment.stocksapp.data.di.repositoryModule
import com.soshdevelopment.stocksapp.domain.di.useCaseModule
import com.soshdevelopment.stocksapp.presenter.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class StocksApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(TimberDebugTree())
        }

        startKoin {
            androidContext(this@StocksApplication)
            modules(
                dataSourceModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }

    private class TimberDebugTree : Timber.DebugTree() {
        override fun createStackElementTag(element: StackTraceElement): String {
            return "(${element.fileName}:${element.lineNumber})/${element.methodName}"
        }
    }
}