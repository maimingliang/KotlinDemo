package com.elk.kotlindemo

import android.app.Application
import com.elk.kotlindemo.di.component.ApiComponent
import javax.inject.Inject

/**
 *
 * 类       名:
 * 说       明:
 * 修 改 记 录:
 * 版 权 所 有:   Copyright © 2017
 * 公       司:   深圳市旅联网络科技有限公司
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

    }


    companion object{ //声明全局变量
        lateinit var instance: App //
    }
}
