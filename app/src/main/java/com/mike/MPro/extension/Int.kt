package com.mike.MPro.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mike.MPro.AppApplication

fun Int.infalte(parent: ViewGroup?, attachToParent: Boolean): View {
    return LayoutInflater.from(AppApplication.context).inflate(this, parent, attachToParent)
}

fun Int.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(AppApplication.context, this, duration).show()
}