package com.library.book.domain.usecase

import com.library.book.domain.repository.BookRepository

class GetSearchBookUseCase(private val repository: BookRepository) {

   operator fun invoke(query: String) = repository.getBooks(query)
}