package com.library.book.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform