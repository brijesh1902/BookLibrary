package com.library.book

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.library.book.di.appModule
import com.library.book.di.initKoin
import com.library.book.presentation.App

fun main() = application {

    initKoin(appModule)

    Window(
        onCloseRequest = ::exitApplication,
        title = "BookLib",
    ) {
        App()
    }
}