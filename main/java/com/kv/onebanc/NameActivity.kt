package com.kv.onebanc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import com.kv.onebanc.callback.InsetsWithKeyboardCallback
import kotlinx.android.synthetic.main.activity_email.*
import kotlinx.android.synthetic.main.activity_invite.*
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        val insetsWithKeyboardCallback = InsetsWithKeyboardCallback(window)
        ViewCompat.setOnApplyWindowInsetsListener(layout_name, insetsWithKeyboardCallback)
        backBtn_Name.setOnClickListener {
            onBackPressed()
        }
        nxt_btn_name.setOnClickListener {
            val name = nameET.text.toString().trim()
            val intent = Intent(this,NumberActivity::class.java)
            if(name.isNotEmpty()) {
                intent.putExtra("user name", name)
                startActivity(intent)
            }
            else{
                nameET.setError("Please enter your name")
            }
        }
    }
}