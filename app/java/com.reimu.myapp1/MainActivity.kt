package com.reimu.myapp1
 
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
 
class MainActivity : AppCompatActivity() {
 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
 
    fun getOmikuji(view: View){
        // 運勢のリストを作成する
        val resultList = listOf("大吉", "中吉", "小吉", "末吉", "凶", "大凶")
 
        // リスト番号をランダムで決める
        val resultNumber = (0..resultList.size-1).random()
 
        // Logcatにリスト番号を出力する
        Log.v("MainActibity", "resultNumber : $resultNumber")
 
        //　決められたリスト番号に該当する運勢を出力する
        resultTextView.text= resultList[resultNumber]
    }
}
