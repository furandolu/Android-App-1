package com.reimu.myapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.google.com/")
    }
       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toolbarを登録
        setSupportActionBar(toolbar)

        //ハンバーガーメニューのアイコンを実装
        //第４、５引数はアクセシビリティで使うみたい。
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.app_name, R.string.app_name
        )
        drawer_layout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

       }
           override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ボタン要素（オブジェクト）を取得
        val buttonToAboutActivity = findViewById<Button>(R.id.button_to_sub)

        // ボタンタップ時のイベントリスナー
        buttonToAboutActivity.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
           }
}
