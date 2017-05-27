package com.elk.kotlindemo.di.component

import com.elk.kotlindemo.mvp.contract.FuckGoodsContract
import com.elk.kotlindemo.ui.fragment.AndroidFragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 *
 * 类       名:
 * 说       明:
 * 修 改 记 录:
 * 版 权 所 有:   Copyright © 2017
 * 公       司:   深圳市旅联网络科技有限公司
 * version   0.1
 * date   2017/5/26
 * author   maimingliang
 */
@Subcomponent(modules = arrayOf(FuckGoodsModule::class))
interface FuckGoodsComponent {
    fun inject(fragment: AndroidFragment)

 }

@Module
class FuckGoodsModule(private val mView: FuckGoodsContract.View){
    @Provides fun getView() = mView
}

