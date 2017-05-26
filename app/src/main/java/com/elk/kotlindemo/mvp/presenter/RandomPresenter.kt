package com.elk.kotlindemo.mvp.presenter

import com.elk.kotlindemo.mvp.contract.RandomContract
import com.elk.kotlindemo.mvp.model.RandomModel
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 *
 * 类       名:
 * 说       明:
 * 修 改 记 录:
 * 版 权 所 有:   Copyright © 2017
 * 公       司:
 * version   0.1
 * date   2017/5/25
 * author   maimingliang
 */

class RandomPresenter
@Inject constructor(protected val mModel: RandomModel, private val mView: RandomContract.View) : RandomContract.Presenter,BasePresenter() {
    override fun getRandom(type: String) {

        addSubscription(mModel.getRandom(type).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    result->
                    if(!result.error){
                        mView.onRandom(result.results[0])
                    }
                },{}))
    }


}