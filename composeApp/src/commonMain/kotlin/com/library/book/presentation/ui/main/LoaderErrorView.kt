package com.library.book.presentation.ui.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UpdateLoaderOrError(
    message: String = "",
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(visible = message.isNotEmpty()) {
            Text(
                color = Color.Black,
                text = message
            )
        }

        AnimatedVisibility(visible = message.isEmpty()) {
            CircularProgressIndicator(
                modifier = Modifier.size(48.dp),
                color = Color.Blue
            )
        }
    }
}
