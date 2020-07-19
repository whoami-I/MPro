package com.mike.MPro.ui.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import androidx.fragment.app.Fragment
import com.mike.MPro.R
import com.mike.MPro.common.callback.RequestLifecycle
import com.mike.MPro.extension.infalte
import org.greenrobot.eventbus.EventBus

abstract class BaseFragment : Fragment(), RequestLifecycle {

    lateinit var rootView: View
    lateinit var loadingView: View
    lateinit var loadErrorView: View
    lateinit var activity: Activity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = getActivity()!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
        rootView = getViewId().infalte(container, false);
        loadingView = rootView.findViewById<View>(R.id.loadingView)
        loadErrorView = rootView.findViewById(R.id.loadingErrorView)
        return rootView
    }

    abstract fun getViewId(): Int

    override fun onDestroyView() {
        super.onDestroyView()
        EventBus.getDefault().unregister(this)
    }

    override fun loadFailed(msg: String?) {
        //展现error view
        if (loadErrorView != null) {
            loadErrorView.visibility = View.VISIBLE
        }
        val loadingErrorStub = rootView.findViewById<ViewStub>(R.id.loadingErrorStubView)
        if (loadingErrorStub != null) {
            loadErrorView = loadingErrorStub.inflate()
            loadErrorView.visibility = View.VISIBLE
        }
    }

    override fun loadFinished() {
        loadingView.visibility = View.GONE
    }

    override fun startLoading() {
        loadingView.visibility = View.VISIBLE
    }
}