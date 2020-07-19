package com.mike.MPro.ui.activity

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.mike.MPro.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        setContentView(R.layout.activity_splash)
        setFullScreen(true)
        var isFull = false
        ivSplashBackground.setOnClickListener {
            setFullScreen(isFull)
            isFull = !isFull
        }
    }
}