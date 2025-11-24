package com.library.book.presentation.ui.main

sealed interface ResponseState<out T> {

    object Idle: ResponseState<Nothing>
    object Loading: ResponseState<Nothing>

    data class Success<out T>(val data: T): ResponseState<T>

    data class Error(val message: String): ResponseState<Nothing>

}