package com.example.libretv

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit  var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)){
                view,insets ->
            val systemBars=insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left,systemBars.top,systemBars.right,systemBars.bottom)
            insets
        }
        webView= findViewById(R.id.webView)
        webView.webViewClient= WebViewClient()
        val settings=webView.settings
        settings.javaScriptEnabled=true
        settings.javaScriptCanOpenWindowsAutomatically=true
        settings.setSupportMultipleWindows(true)
        settings.domStorageEnabled=true
        settings.domStorageEnabled=true
        settings.allowFileAccess=true
        webView.loadUrl("https://libertv-etp.pages.dev")
        onBackPressedDispatcher.addCallback(this){
            if(webView.canGoBack()){
                webView.goBack()
            }else{
                finish()
            }
        }
    }
}