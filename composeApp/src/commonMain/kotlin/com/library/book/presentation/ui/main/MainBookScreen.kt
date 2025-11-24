package com.library.book.presentation.ui.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.library.book.presentation.theme.White_30
import com.library.book.presentation.ui.main.viewmodel.MainBooksViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MainBookScreen(
    viewModel: MainBooksViewModel = koinViewModel(),
) {
    val state by viewModel.bookResponseState.collectAsStateWithLifecycle()
    var query by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize()
            .background(color = Color.Transparent)
            .padding(16.dp)
    ) {

        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            colors = SearchBarDefaults.colors(containerColor = White_30),
            inputField = {
                SearchBarDefaults.InputField(
                    query = query,
                    onQueryChange = {
                        query = it
                    },
                    onSearch = {
                        viewModel.fetchBookData(query)
                        active = false
                    },
                    leadingIcon = {
                        Icon(
                            modifier = Modifier.padding(8.dp),
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    },
                    trailingIcon = {
                        AnimatedVisibility(visible = active) {
                            Icon(
                                modifier = Modifier.padding(8.dp)
                                    .clickable {
                                        query = ""
                                    },
                                imageVector = Icons.Default.Close,
                                contentDescription = "Clear"
                            )
                        }
                    },
                    placeholder = {
                        Text(text = "Search books...", color = Color.Gray)
                    },
                    expanded = active,
                    onExpandedChange = {
                        active = it
                    },
                )
            },
            expanded = false,
            onExpandedChange = {
            },
            shape = SearchBarDefaults.inputFieldShape,
            tonalElevation = SearchBarDefaults.TonalElevation,
            shadowElevation = SearchBarDefaults.ShadowElevation,
            windowInsets = SearchBarDefaults.windowInsets,
            content = {

            },
        )

        when (val viewState = state) {

            is ResponseState.Idle -> UpdateLoaderOrError("Search books via name, title...")

            is ResponseState.Loading -> UpdateLoaderOrError()

            is ResponseState.Error -> UpdateLoaderOrError(viewState.message)

            is ResponseState.Success -> BookListView(viewState.data)

        }
    }
}