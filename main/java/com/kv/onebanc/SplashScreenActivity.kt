package com.kv.onebanc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val videoPath = "android.resource://"+packageName+"/"+R.raw.splash_vid
        val videoUri = Uri.parse(videoPath)
        splashVideo.setVideoURI(videoUri)
        splashVideo.start()
        splashVideo.post(object : Runnable{
            override fun run() {
                val videoWidth = 16f
                val videoHeight = 9f
                val screenarheight = 9f

                val videoscale: Float = screenarheight / videoHeight

                val videoarratio: Float = videoWidth / videoHeight
                val videoscaledarratio = videoarratio * videoscale
                val layoutparams = splashVideo.layoutParams
                layoutparams.width = (splashVideo.height * videoscaledarratio).toInt()

                splashVideo.layoutParams= layoutparams
            }

        })

        splashVideo.setOnCompletionListener {
            startActivity(Intent(this,SplashActivity::class.java))
            finish()

        }
    }
}