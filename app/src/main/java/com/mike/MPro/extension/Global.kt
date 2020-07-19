package com.mike.MPro.extension

import android.view.View

fun setClickListener(vararg views: View, listener: View.OnClickListener) {
    views.forEach { it.setOnClickListener(listener) }
}

fun setClickListener(vararg views: View, block: () -> Unit) {
    var listener = View.OnClickListener { block() }
    views.forEach { it.setOnClickListener(listener) }
}