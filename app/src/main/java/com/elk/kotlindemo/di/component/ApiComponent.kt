package com.elk.kotlindemo.di.component

import com.elk.kotlindemo.App
import com.elk.kotlindemo.di.module.ApiModule
import dagger.Component

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

@Component(modules = arrayOf(ApiModule::class))
interface ApiComponent{

    fun inject(app: App)

    fun plus(module: RandomModule):RandomComponent
     fun plus(module: FuckGoodsModule):FuckGoodsComponent
}