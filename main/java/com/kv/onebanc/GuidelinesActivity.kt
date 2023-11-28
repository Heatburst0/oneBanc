package com.kv.onebanc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_guidelines.*

class GuidelinesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guidelines)
        btn_cancel.setOnClickListener {
            finish()
        }
        btn_guidelines_ready.setOnClickListener {
            startActivity(Intent(this,PermissionsActivity::class.java))
            finish()
        }
    }
}