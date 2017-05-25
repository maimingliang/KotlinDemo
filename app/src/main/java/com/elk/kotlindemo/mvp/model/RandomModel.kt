package com.elk.kotlindemo.mvp.model

import com.elk.kotlindemo.api.GankApi
import com.elk.kotlindemo.bean.FuckGoods
import com.elk.kotlindemo.mvp.contract.JsonResult
import com.elk.kotlindemo.mvp.contract.RandomContract
import rx.Observable
import javax.inject.Inject

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

class RandomModel
@Inject constructor(private val api: GankApi): RandomContract.Model {

    override fun getRandom(type: String): Observable<JsonResult<List<FuckGoods>>> {

        return api.getRandom(type)

    }
}