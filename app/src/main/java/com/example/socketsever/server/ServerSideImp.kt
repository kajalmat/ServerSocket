package com.example.socketsever.server

import android.content.Context
import android.widget.Toast
import java.net.ServerSocket

 class ServerSideImp() {

    val serverSocket = ServerSocket(12345) // Port to listen on

     fun getSocketimp(context:Context){
        while (true) {
            val clientSocket = serverSocket.accept()

            val inputStream = clientSocket.getInputStream()
            val inputMessage = inputStream.bufferedReader().readLine()
            println("Received from client: $inputMessage")
            Toast.makeText(context,"Received from client: $inputMessage",Toast.LENGTH_LONG).show()
            // Handle the message as needed

            clientSocket.close()
        }
    }


}