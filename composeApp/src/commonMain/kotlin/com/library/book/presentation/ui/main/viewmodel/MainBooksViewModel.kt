package com.library.book.presentation.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import com.library.book.domain.model.BookSearchResponseModel
import com.library.book.domain.usecase.GetSearchBookUseCase
import com.library.book.presentation.ui.main.ResponseState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainBooksViewModel(
    val useCase: GetSearchBookUseCase,
) : ViewModel() {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    private val _bookResponseState = MutableStateFlow<ResponseState<BookSearchResponseModel>>(ResponseState.Idle)
    val bookResponseState get() = _bookResponseState.asStateFlow()

    fun fetchBookData(query: String) = viewModelScope.launch {
        _bookResponseState.value = ResponseState.Loading
        useCase.invoke(query)
            .catch {
                _bookResponseState.value = ResponseState.Error(it.message.toString())
            }.collect {
                _bookResponseState.value = ResponseState.Success(it)
            }
    }

}