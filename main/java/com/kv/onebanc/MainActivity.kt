package com.kv.onebanc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_guidelines.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var userName : String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(intent.hasExtra("user name")){
            userName = intent.getStringExtra("user name")
            heading_main.setText("Congratulations ${userName}!")
        }
        btn_cancel_main.setOnClickListener {
            startActivity(Intent(this,SplashActivity::class.java))
            finish()
        }
    }
}