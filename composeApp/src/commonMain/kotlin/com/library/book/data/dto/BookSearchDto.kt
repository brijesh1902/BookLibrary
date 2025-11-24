package com.library.book.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookSearchDto(
    @SerialName("docs")
    val docs: List<DocDataDto> = listOf(),
    @SerialName("documentation_url")
    val documentationUrl: String = "",
    @SerialName("num_found")
    val numFound: Int = 0,
    @SerialName("numFoundExact")
    val numFoundExact: Boolean = false,
    @SerialName("offset")
    val offset: String? = null,
    @SerialName("q")
    val query: String = "",
    @SerialName("start")
    val start: Int = 0
)