package com.kv.onebanc

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_guidelines.*
import kotlinx.android.synthetic.main.activity_guidelines.btn_cancel
import kotlinx.android.synthetic.main.activity_permissions.*

class PermissionsActivity : AppCompatActivity() {

    private val permissionsList  = arrayOf(Manifest.permission.READ_SMS,Manifest.permission.CAMERA
                                    ,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.RECORD_AUDIO)
    private val requestPermissionCode=12
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)
        btn_cancel.setOnClickListener {
            finish()
        }
        btn_grantPermissions.setOnClickListener {
            ActivityCompat.requestPermissions(this,permissionsList,12)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==requestPermissionCode && grantResults.isNotEmpty()){
            var allgranted = true
            for(i in grantResults.indices){
                if(grantResults[i]==PackageManager.PERMISSION_DENIED){
                    Toast.makeText(this,"Please allow all permissions to move forward ",Toast.LENGTH_SHORT).show()
                    allgranted=false
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    intent.setData(Uri.fromParts("package",packageName,null))
                    startActivity(intent)
                }

            }
            if(allgranted){
                startActivity(Intent(this,InviteActivity::class.java))
                finish()
            }


        }
    }
}