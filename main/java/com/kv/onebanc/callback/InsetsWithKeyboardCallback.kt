package com.kv.onebanc.callback

import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsAnimation.Callback.DISPATCH_MODE_CONTINUE_ON_SUBTREE
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.view.*
import com.google.android.material.color.DynamicColors


class InsetsWithKeyboardCallback(window : Window) : OnApplyWindowInsetsListener {

    private var deferredInsets = false
    private var view: View? = null
    private var lastWindowInsets: WindowInsetsCompat? = null

    init {
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // For better support for devices API 29 and lower
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
            @Suppress("DEPRECATION")
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        }
    }
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onApplyWindowInsets(v: View, insets: WindowInsetsCompat): WindowInsetsCompat {
        val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //  System Bars' and Keyboard's insets combined
        val systemBarsIMEInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars() + WindowInsetsCompat.Type.ime())

        // We use the combined bottom inset of the System Bars and Keyboard to move the view so it doesn't get covered up by the keyboard
        v!!.setPadding(systemBarsInsets!!.left, systemBarsInsets.top, systemBarsInsets!!.right, systemBarsIMEInsets!!.bottom)
        return WindowInsetsCompat.CONSUMED
    }

}