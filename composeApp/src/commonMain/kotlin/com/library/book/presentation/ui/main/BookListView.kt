package com.library.book.presentation.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.library.book.domain.model.BookSearchResponseModel

@Composable
fun BookListView(
    bookSearchResponseModel: BookSearchResponseModel,
) {
    if (bookSearchResponseModel.bookList.isEmpty()) {
        UpdateLoaderOrError("No Data Found.")
        return
    }
    LazyColumn(
        Modifier.fillMaxSize().padding(vertical = 16.dp)
    ) {
        items(bookSearchResponseModel.bookList) {
            BooksViewCard(it) {

            }
        }

    }
}
