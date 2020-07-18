package com.mike.MPro

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    var BASE_URL = "https://api.github.com/users/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build()
        val apiService = retrofit.create(ApiService::class.java)
//        apiService.getEntity().enqueue(object: Callback<MEntity>{
//            override fun onFailure(call: Call<MEntity>, t: Throwable) {
//                Timber.d("fail")
//            }
//
//            override fun onResponse(call: Call<MEntity>, response: Response<MEntity>) {
//                Timber.d(response.body().toString())
//            }
//
//        })
//
//        val launch = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())
//            .async {
//                Timber.tag("TAGTAG")
//                    .d(Thread.currentThread().toString())
//            }

        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
            .url("http://baobab.kaiyanapp.com/api/v7/index/tab/discovery")
            .header("model", "Android")
            .header("If-Modified-Since", "${Date()}")
            .header("User-Agent", System.getProperty("http.agent") ?: "unknown")
            //.url("https://api.github.com/users/basil2style")
            .build()
        val newHttpUrl = request.url().newBuilder()
            .addQueryParameter("udid", GlobalUtil.getDeviceSerial())
            .addQueryParameter("vc", GlobalUtil.eyepetizerVersionCode.toString())
            .addQueryParameter("vn", GlobalUtil.eyepetizerVersionName)
            .addQueryParameter("size", GlobalUtil.screenPixel())
            .addQueryParameter("deviceModel", GlobalUtil.deviceModel)
            .addQueryParameter("first_channel", GlobalUtil.deviceBrand)
            .addQueryParameter("last_channel", GlobalUtil.deviceBrand)
            .addQueryParameter("system_version_code", "${Build.VERSION.SDK_INT}")
            .build()
        val newCall = okHttpClient.newCall(request.newBuilder()
            .url(newHttpUrl)
            .get()
            .header("model", "Android")
            .header("If-Modified-Since", "${Date()}")
            .header("User-Agent", System.getProperty("http.agent") ?: "unknown")
            .method(request.method(),request.body())
            .build())
        newCall.enqueue(object :okhttp3.Callback{
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                Log.d("TAGTAG","fail")
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                Timber.d(response.body()!!.string())
            }

        })

//        val discoveryApiService = ServiceCreator.create(DiscoveryApiService::class.java)
//        discoveryApiService.getDiscovery().enqueue(object :Callback<HEN>{
//            override fun onFailure(call: Call<HEN>, t: Throwable) {
//                Timber.d(t)
//            }
//
//            override fun onResponse(call: Call<HEN>, response: Response<HEN>) {
//                Timber.d(response.body().toString())
//            }
//
//        })


//        val m1 = MutableLiveData<Int>()
//        m1.value = 1
//        val m2 = MutableLiveData<Int>()
//        m2.value = 10
//        val m3 = Transformations.switchMap(m1) {
//            m2
//        }
//        m3.observe(this, Observer {
//            Timber.tag("TAGTAG").d("${m3.value}")
//        })
//        tv1.setOnClickListener{
//            m1.value = m1.value?.plus(1)
//        }
//        tv2.setOnClickListener{
//            m2.value = m2.value?.plus(1)
//        }
    }
}
