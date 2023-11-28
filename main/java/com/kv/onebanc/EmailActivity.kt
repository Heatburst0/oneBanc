package com.kv.onebanc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import com.kv.onebanc.callback.InsetsWithKeyboardCallback
import kotlinx.android.synthetic.main.activity_email.*
import kotlinx.android.synthetic.main.activity_invite.*

class EmailActivity : AppCompatActivity() {
    var userName : String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)
        val insetsWithKeyboardCallback = InsetsWithKeyboardCallback(window)
        ViewCompat.setOnApplyWindowInsetsListener(layout_email, insetsWithKeyboardCallback)
        nxt_btn_email.setOnClickListener {
            if(intent.hasExtra("user name")){
                userName = intent.getStringExtra("user name")
            }
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("user name",userName)
            startActivity(intent)

        }
        backBtn_email.setOnClickListener {
            onBackPressed()
        }
    }
}