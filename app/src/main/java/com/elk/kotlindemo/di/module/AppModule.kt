package com.elk.kotlindemo.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

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
@Module
class AppModule(private val context: Context){
    @Provides fun provideContext() = context

}
