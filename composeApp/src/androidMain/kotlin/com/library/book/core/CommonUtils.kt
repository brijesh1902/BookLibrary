package com.library.book.core

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext

@Composable
fun rememberNetworkStatus(): State<Boolean> {
    val context = LocalContext.current

    return produceState(initialValue = true) {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                value = true
            }

            override fun onLost(network: Network) {
                value = false
            }
        }

        cm.registerDefaultNetworkCallback(callback)

        awaitDispose {
            cm.unregisterNetworkCallback(callback)
        }
    }
}