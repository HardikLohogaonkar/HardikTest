package com.peopleinteractive.hardiktest.network

import com.peopleinteractive.hardiktest.BuildConfig
import com.peopleinteractive.hardiktest.network.NetworkApiConstant.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object NetworkApiClient {

    private var mNetworkService: NetworkService? = null
    private var httpClient: OkHttpClient.Builder? = null


    private fun getRetrofitClient() {

        httpClient = OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            readTimeout(5000, TimeUnit.MILLISECONDS)
            writeTimeout(5000, TimeUnit.MILLISECONDS)
            connectTimeout(5000, TimeUnit.MILLISECONDS)
        }

        val retrofit = Retrofit.Builder().run {
            baseUrl(BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            client(httpClient!!.build())
            build()
        }

        mNetworkService = retrofit.create(NetworkService::class.java)
    }

    fun getNetworkServices(): NetworkService {
        return if (mNetworkService != null) {
            mNetworkService as NetworkService
        } else {
            getRetrofitClient()
            mNetworkService as NetworkService
        }
    }
}