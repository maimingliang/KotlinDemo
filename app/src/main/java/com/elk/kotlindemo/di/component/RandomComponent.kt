package com.elk.kotlindemo.di.component

import com.elk.kotlindemo.mvp.contract.RandomContract
import com.elk.kotlindemo.ui.activity.MainActivity
import dagger.Component
import dagger.Module
import dagger.Provides

/**
 *
 * 类       名:
 * 说       明:
 * 修 改 记 录:
 * 版 权 所 有:   Copyright © 2017
 * 公       司:   深圳市旅联网络科技有限公司
 * version   0.1
 * date   2017/5/25
 * author   maimingliang
 */
@Component(modules = arrayOf(RandomModule::class))
interface RandomComponent{
    fun inject(activity: MainActivity)
}


@Module
class RandomModule(private val mView: RandomContract.View){
    @Provides fun getView() = mView
}