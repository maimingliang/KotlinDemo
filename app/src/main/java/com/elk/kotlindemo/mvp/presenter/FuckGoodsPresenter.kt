package com.elk.kotlindemo.mvp.presenter

import android.util.Log
import com.elk.kotlindemo.mvp.contract.FuckGoodsContract
import com.elk.kotlindemo.mvp.model.FuckGoodsModel
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

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

class FuckGoodsPresenter
@Inject constructor(private val mModel: FuckGoodsModel,private val mView: FuckGoodsContract.View): FuckGoodsContract.Presenter,BasePresenter(){
    override fun getData(page: Int, type: String) {
        addSubscription(mModel.getData(page, type).observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    res ->
                    if (!res.error) {
                        mView.setData(res.results)
                    }

                }, { e -> Log.e("wing", "error android Presenter" + e.message) }))
    }
}