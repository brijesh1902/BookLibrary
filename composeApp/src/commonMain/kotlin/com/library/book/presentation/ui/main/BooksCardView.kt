package com.library.book.presentation.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import booklib.composeapp.generated.resources.Res
import booklib.composeapp.generated.resources.error_image
import coil3.compose.AsyncImage
import com.library.book.domain.model.BookSearchModel
import org.jetbrains.compose.resources.painterResource


@Composable
fun BooksViewCard(
    bookModel: BookSearchModel,
    onBookSelected: (BookSearchModel) -> Unit
) {
    val coverImage by rememberSaveable { mutableStateOf("https://covers.openlibrary.org/b/id/${bookModel.coverI}-M.jpg") }

    Card(
        modifier = Modifier.fillMaxWidth()
            .clickable {
                onBookSelected(bookModel)
            }
            .padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = coverImage,
                modifier = Modifier.size(width = 80.dp, height = 120.dp).padding(8.dp)
                    .clipToBounds().clip(RoundedCornerShape(8.dp)),
                contentDescription = "image",
                contentScale = ContentScale.FillBounds,
                error = painterResource(Res.drawable.error_image)
            )
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = bookModel.title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    color = Color.Black
                )
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = "Author: ${bookModel.authorName}",
                    style = TextStyle(
                        fontSize = 14.sp
                    ),
                    color = Color.DarkGray
                )
                Text(
                    text = "First published in ${bookModel.firstPublishYear} — ${bookModel.editionCount} editions",
                    style = TextStyle(
                        fontSize = 12.sp
                    ),
                    color = Color.Gray,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}
