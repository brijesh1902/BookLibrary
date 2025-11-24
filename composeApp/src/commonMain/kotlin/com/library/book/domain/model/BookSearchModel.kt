package com.library.book.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookSearchModel(
    @SerialName("author_key")
    val authorKey: List<String>? = null,
    @SerialName("author_name")
    val authorName: String = "",
    @SerialName("cover_edition_key")
    val coverEditionKey: String? = null,
    @SerialName("cover_i")
    val coverI: Int? = null,
    @SerialName("ebook_access")
    val ebookAccess: String = "",
    @SerialName("edition_count")
    val editionCount: Int = 0,
    @SerialName("first_publish_year")
    val firstPublishYear: Int? = null,
    @SerialName("has_fulltext")
    val hasFulltext: Boolean = false,
    @SerialName("ia")
    val ia: List<String>? = null,
    @SerialName("ia_collection_s")
    val iaCollectionS: String? = null,
    @SerialName("key")
    val key: String = "",
    @SerialName("language")
    val language: List<String>? = null,
    @SerialName("lending_edition_s")
    val lendingEditionS: String? = null,
    @SerialName("lending_identifier_s")
    val lendingIdentifierS: String? = null,
    @SerialName("public_scan_b")
    val publicScanB: Boolean = false,
    @SerialName("subtitle")
    val subtitle: String? = null,
    @SerialName("title")
    val title: String = ""
)

data class BookSearchResponseModel(
    val bookList: List<BookSearchModel> = listOf()
)
