package com.library.book.data.repository

import com.library.book.data.dto.BookSearchDto
import com.library.book.data.mapper.toModelMapper
import com.library.book.domain.model.BookSearchResponseModel
import com.library.book.domain.repository.BookRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BookRepositoryImpl(val httpClient: HttpClient) : BookRepository {

    override fun getBooks(query: String): Flow<BookSearchResponseModel> {
        return flow {
           val result = httpClient.get("search.json") {
               url {
                   parameters.append("q", query)
               }
           }.body<BookSearchDto>()
            emit(result.toModelMapper())
        }
    }

}