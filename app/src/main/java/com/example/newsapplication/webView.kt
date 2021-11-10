package com.example.newsapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView

class webView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        var webView : WebView  = findViewById<WebView>(R.id.webView)

        var intent : Intent = getIntent()
        var url : String? = intent.getStringExtra("url")

    }
}