package com.elk.kotlindemo.di.module

import android.content.Context
import android.util.Log
import com.elk.kotlindemo.api.GankApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers
import java.io.File

/**
 *
 * 类       名:
 * 说       明:
 * 修 改 记 录:
 * 版 权 所 有:   Copyright © 2017
 * 公       司:
 * version   0.1
 * date   2017/5/24
 * author   maimingliang
 */
@Module(includes = arrayOf(AppModule::class))
class ApiModule{

    @Provides fun provideRetrofit(baseUrl: HttpUrl, client: OkHttpClient, gson: Gson) =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build();

    @Provides fun provideBaseUrl() = HttpUrl.parse("http://gank.io/api/")

    @Provides fun provideOkHttp(context: Context, interceptor: HttpLoggingInterceptor): OkHttpClient{

        val cacheSize = 1024 * 1024 *10L
        val cacheDir = File(context.cacheDir,"http")
        val cache = Cache(cacheDir,cacheSize)
        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor)
                .build();

    }

    @Provides fun provideInterceptor(): HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor{
            msg -> Log.d("okhttp",msg)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides fun provideGson() = GsonBuilder().create()
    @Provides fun provideApi(retrofit: Retrofit) = retrofit.create(GankApi::class.java)
}