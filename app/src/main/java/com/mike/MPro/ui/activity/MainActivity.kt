package com.mike.MPro.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViews()
    }

    override fun setUpViews() {

    }

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}