package com.quo.booksurfer.presentation.screens.search

data class SearchScreenState(
    val bookList: List<String> = emptyList(), // TODO(Implement book model instead of string)
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
)