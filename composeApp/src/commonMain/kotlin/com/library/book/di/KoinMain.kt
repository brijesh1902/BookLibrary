package com.library.book.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(appModule: Module) {
    startKoin {
        printLogger()
        modules(appModule)
    }
}