package com.kv.onebanc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.view.ViewCompat
import com.kv.onebanc.callback.InsetsWithKeyboardCallback
import kotlinx.android.synthetic.main.activity_invite.*

class InviteActivity : AppCompatActivity() {
    var userName : String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite)
        val insetsWithKeyboardCallback = InsetsWithKeyboardCallback(window)
        ViewCompat.setOnApplyWindowInsetsListener(invite_layout, insetsWithKeyboardCallback)
        nxt_btn_invite.setOnClickListener {
            startActivity(Intent(this,NameActivity::class.java))
            finish()
        }
        backBtn_invite.setOnClickListener {
            onBackPressed()
        }
        inviteCodeEt.requestFocus()



    }

}