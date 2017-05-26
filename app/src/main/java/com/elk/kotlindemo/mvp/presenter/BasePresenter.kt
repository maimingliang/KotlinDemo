package com.elk.kotlindemo.mvp.presenter

import rx.Subscription
import rx.subscriptions.CompositeSubscription

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

open class BasePresenter{

    val compositeSubscription = CompositeSubscription()

    protected fun addSubscription(subscription: Subscription){
        compositeSubscription.add(subscription)

    }

    fun unSubscription(){
        if(compositeSubscription.hasSubscriptions()){
            compositeSubscription.unsubscribe()
        }
    }
}