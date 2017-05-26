package com.elk.kotlindemo

import android.app.Application
import com.elk.kotlindemo.di.component.ApiComponent
import com.elk.kotlindemo.di.component.DaggerApiComponent
import com.elk.kotlindemo.di.module.ApiModule
import com.elk.kotlindemo.di.module.AppModule
import javax.inject.Inject

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

class App : Application() {
    init {
        instance = this
     }

    @Inject lateinit var apiCompontent: ApiComponent

    override fun onCreate() {
        super.onCreate()
        DaggerApiComponent.builder().apiModule(ApiModule()).appModule(AppModule(this)).build().inject(this)
    }


    companion object{ //声明全局变量
        lateinit var instance: App //
    }
}
