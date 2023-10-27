package com.example.socketsever

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.socketsever.server.ServerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    val serverSocket:ServerSocket=ServerSocket()
    private val executor: ExecutorService = Executors.newFixedThreadPool(1)
    lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        serverCall();
    }

    private fun serverCall() {


        tv=findViewById(R.id.tv)
        tv.text="Please Wait..."
        ServerRepository( Dispatchers.Default,this)
        tv.text="Conneting..."



    }
    suspend fun  excuteServerSocket(){

    }
    private fun clientCall() {




        val serverIP = "Server_IP_Address" // Replace with the IP address of Device 1
        val serverPort = 12345 // Port where the server is listening

        val message = "Hello from client!"

        val clientSocket = Socket(serverIP, serverPort)

        val outputStream = clientSocket.getOutputStream()
        outputStream.write(message.toByteArray())
        outputStream.flush()

        clientSocket.close()





    }
}

