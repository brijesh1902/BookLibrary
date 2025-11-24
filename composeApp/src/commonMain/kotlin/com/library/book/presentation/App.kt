package com.library.book.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.library.book.presentation.ui.main.MainBookScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(
            Modifier.fillMaxSize()
        ) {
            /*Image(
                painter = painterResource(Res.drawable.background),
                contentDescription = "background",
                contentScale = ContentScale.Crop,
                alpha = 0.9f,
                colorFilter = ColorFilter.tint(color = Color.Black, blendMode = BlendMode.Plus)
            )*/
            MainBookScreen()
        }
    }
}