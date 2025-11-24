package com.library.book

import android.app.Application
import com.library.book.di.appModule
import com.library.book.di.initKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(appModule)
    }

}