package com.mike.MPro.ui.activity

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar
import com.mike.MPro.R
import com.mike.MPro.event.MessageEvent
import kotlinx.coroutines.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import kotlin.coroutines.CoroutineContext


abstract class BaseActivity : AppCompatActivity() {

    var job: Job? = null
    var shouldStopJobWhenDestroy = true
    val mainScope: CoroutineScope by lazy {
        job = SupervisorJob()
        CoroutineScope(job as CompletableJob + Dispatchers.Main.immediate)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
//        setStatusBarBackground(R.color.colorPrimaryDark)
//        setUpViews()
    }

    abstract fun setUpViews()

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
        if (shouldStopJobWhenDestroy) job?.cancel()
    }

    /**
     * 设置状态栏背景色
     */
    open fun setStatusBarBackground(@ColorRes statusBarColor: Int) {
        ImmersionBar.with(this).autoStatusBarDarkModeEnable(true, 0.2f)
            .statusBarColor(statusBarColor).fitsSystemWindows(true).init()
    }

    @Subscribe
    open fun onGetMessage(event: MessageEvent) {

    }

    fun setFullScreen(fullScreen: Boolean) {
        var uiOptions = 0
        val lp = window.attributes

        if (fullScreen) {
            lp.flags = lp.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
        } else {
            lp.flags = lp.flags and WindowManager.LayoutParams.FLAG_FULLSCREEN.inv()
        }

        if (fullScreen) {
            uiOptions = (
                    View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_IMMERSIVE
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    )
        } else {
            uiOptions = (
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    )
        }
        window.decorView.systemUiVisibility = uiOptions
    }

}