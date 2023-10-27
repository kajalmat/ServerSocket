package com.example.socketsever.server

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.ServerSocket

class ServerRepository( private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default,val context:Context) {
    val serverSocket = ServerSocket(12345) // Port to listen on

    suspend fun loadNews() = withContext(defaultDispatcher) {
         ServerSideImp().getSocketimp(context)
    }

}