package com.example.wrappedwebviewpoc

import android.os.Bundle
import android.webkit.ClientCertRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private val useClientCert = true // Change this to toggle client certificate usage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true

        // Load the client certificate
        val (privateKey, certChain) = CertificateUtil.loadCertificate(this, "badssl.com")

        // Set WebViewClient
        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedClientCertRequest(view: WebView, request: ClientCertRequest) {
                if (useClientCert) {
                    request.proceed(privateKey, certChain) // Use the client certificate
                } else {
                    request.ignore() // Ignore the client certificate request
                }
            }
        }

        // Load the test URL
        webView.loadUrl("https://client.badssl.com/")
    }
}