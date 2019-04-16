package com.bw.myfirstkotlin

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import stsfan.com.kotlinstu.utils.Api
import stsfan.com.kotlinstu.utils.NetWorkUtils
import java.util.concurrent.TimeUnit

/**
 * @copyright:  zhidu
 * @author   fanyanlong
 * @email  326445811@qq.com
 * @versions：  V1.0.1
 * @data： 2019/4/16
 * @description：网络请求okhttp+retrofit
 * 异步处理Rxjava
 *
 */

class RetrofitUtils {
    //companion object 静态
    //by lazy   lateinit 只用于变量 var，而 lazy 只用于常量 val
    companion object {
        val instance: RetrofitUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitUtils()
        }
    }

    private var okclient = OkHttpClient.Builder()
            .addInterceptor(
                    HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(8, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Api.BaseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okclient)
            .build()
    //获取半生类 于java反射
    val create = retrofit.create(NetWorkUtils::class.java)
}