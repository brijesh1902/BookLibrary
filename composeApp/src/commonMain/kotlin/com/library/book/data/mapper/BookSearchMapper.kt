package com.library.book.data.mapper

import com.library.book.data.dto.BookSearchDto
import com.library.book.domain.model.BookSearchModel
import com.library.book.domain.model.BookSearchResponseModel

fun BookSearchDto.toModelMapper(): BookSearchResponseModel {
    val bookList = this.docs.map { dto ->
        BookSearchModel(
            authorKey = dto.authorKey,
            authorName = dto.authorName.toString().replace("[", "").replace("]", ""),
            coverEditionKey = dto.coverEditionKey,
            coverI = dto.coverI,
            ebookAccess = dto.ebookAccess,
            editionCount = dto.editionCount,
            firstPublishYear = dto.firstPublishYear,
            hasFulltext = dto.hasFulltext,
            ia = dto.ia,
            iaCollectionS = dto.iaCollectionS,
            key = dto.key,
            language = dto.language,
            lendingEditionS = dto.lendingEditionS,
            lendingIdentifierS = dto.lendingIdentifierS,
            publicScanB = dto.publicScanB,
            subtitle = dto.subtitle,
            title = dto.title,

        )
    }
    return BookSearchResponseModel(
        bookList = bookList.distinctBy { it.key }.subList(0, 10)
    )
}