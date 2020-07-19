package com.mike.MPro.ui.activity

import android.Manifest
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.mike.MPro.GlobalUtil
import com.mike.MPro.R
import com.permissionx.guolindev.PermissionX
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {
    val ANIMATION_DURATION: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        )
        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
        )
        requestWriteExternalStoragePermission()
    }

    override fun setUpViews() {
        setContentView(R.layout.activity_splash)
        setFullScreen(true)
        val scaleAnimation = ScaleAnimation(
            1F,
            1.2f,
            1F,
            1.2f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        ).apply {
            duration = ANIMATION_DURATION
            repeatCount = 0
            fillAfter = true
        }
        ivSplashBackground.startAnimation(scaleAnimation)
        shouldStopJobWhenDestroy = false
        mainScope.launch {
            delay(ANIMATION_DURATION)
            MainActivity.startActivity(this@SplashActivity)
            finish()
        }
    }


    private fun requestWriteExternalStoragePermission() {
        PermissionX.init(this@SplashActivity)
            .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .onExplainRequestReason { scope, deniedList ->
                val message = GlobalUtil.getString(R.string.request_permission_picture_processing)
                scope.showRequestReasonDialog(
                    deniedList,
                    message,
                    GlobalUtil.getString(R.string.ok),
                    GlobalUtil.getString(R.string.cancel)
                )
            }
            .onForwardToSettings { scope, deniedList ->
                val message = GlobalUtil.getString(R.string.request_permission_picture_processing)
                scope.showForwardToSettingsDialog(
                    deniedList,
                    message,
                    GlobalUtil.getString(R.string.settings),
                    GlobalUtil.getString(R.string.cancel)
                )
            }
            .request { allGranted, grantedList, deniedList ->
                requestReadPhoneStatePermission()
            }
    }

    private fun requestReadPhoneStatePermission() {
        PermissionX.init(this@SplashActivity).permissions(Manifest.permission.READ_PHONE_STATE)
            .onExplainRequestReason { scope, deniedList ->
                val message = GlobalUtil.getString(R.string.request_permission_access_phone_info)
                scope.showRequestReasonDialog(
                    deniedList,
                    message,
                    GlobalUtil.getString(R.string.ok),
                    GlobalUtil.getString(R.string.cancel)
                )
            }
            .onForwardToSettings { scope, deniedList ->
                val message = GlobalUtil.getString(R.string.request_permission_access_phone_info)
                scope.showForwardToSettingsDialog(
                    deniedList,
                    message,
                    GlobalUtil.getString(R.string.settings),
                    GlobalUtil.getString(R.string.cancel)
                )
            }
            .request { allGranted, grantedList, deniedList ->
                setUpViews()
            }
    }

    fun testFullScreen() {
        var isFull = false
        ivSplashBackground.setOnClickListener {
            setFullScreen(isFull)
            isFull = !isFull
        }
    }
}