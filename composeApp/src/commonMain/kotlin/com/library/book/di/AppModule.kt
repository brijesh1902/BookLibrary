package com.library.book.di

import com.library.book.data.repository.BookRepositoryImpl
import com.library.book.domain.repository.BookRepository
import com.library.book.domain.usecase.GetSearchBookUseCase
import com.library.book.presentation.ui.main.viewmodel.MainBooksViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Defines single instance of Ktor client
    single {
        HttpClient {
            defaultRequest {
                url("https://openlibrary.org/")
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
                sanitizeHeader { header ->
                    header == HttpHeaders.Authorization
                }
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }
        }
    }

    // singleton for Repository
    single<BookRepository> {
        BookRepositoryImpl(httpClient = get())
    }

    // singleton for use cases
    single<GetSearchBookUseCase> {
        GetSearchBookUseCase(repository = get())
    }

    // Factory for viewmodel
    viewModel {
        MainBooksViewModel(useCase = get())
    }

}