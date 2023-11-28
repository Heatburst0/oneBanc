package com.kv.onebanc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import com.kv.onebanc.callback.InsetsWithKeyboardCallback
import kotlinx.android.synthetic.main.activity_email.*
import kotlinx.android.synthetic.main.activity_invite.*
import kotlinx.android.synthetic.main.activity_number.*

class NumberActivity : AppCompatActivity() {
    var userName : String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
        val insetsWithKeyboardCallback = InsetsWithKeyboardCallback(window)
        ViewCompat.setOnApplyWindowInsetsListener(layout_number, insetsWithKeyboardCallback)
        nxt_btn_number.setOnClickListener {
            if(intent.hasExtra("user name")){
                userName = intent.getStringExtra("user name")
            }
            val intent =Intent(this,EmailActivity::class.java)
            if(!userName.isNullOrEmpty())
                intent.putExtra("user name",userName!!)
            startActivity(intent)

        }
        backBtn_number.setOnClickListener {
            onBackPressed()
        }
    }
}