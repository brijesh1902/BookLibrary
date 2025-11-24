package com.library.book.domain.repository

import com.library.book.domain.model.BookSearchResponseModel
import kotlinx.coroutines.flow.Flow

interface BookRepository {

    fun getBooks(query: String): Flow<BookSearchResponseModel>

}