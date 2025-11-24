package com.library.book

import androidx.compose.ui.window.ComposeUIViewController
import com.library.book.di.appModule
import com.library.book.di.initKoin
import com.library.book.presentation.App

fun MainViewController() = ComposeUIViewController {

    initKoin(appModule)

    App()
}