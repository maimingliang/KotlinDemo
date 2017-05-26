package com.elk.kotlindemo.mvp.model

import com.elk.kotlindemo.api.GankApi
import com.elk.kotlindemo.bean.FuckGoods
import com.elk.kotlindemo.bean.JsonResult
import com.elk.kotlindemo.mvp.contract.FuckGoodsContract
import com.elk.kotlindemo.ui.fragment.AndroidFragment
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
 * date   2017/5/26
 * author   maimingliang
 */

class FuckGoodsModel @Inject constructor(private val api: GankApi) : FuckGoodsContract.Model {

    override fun getData(page: Int, type: String): Observable<JsonResult<List<FuckGoods>>> {
        when (type) {
            AndroidFragment.ANDROID -> return api.getAndroidData(page)
//            IOSFragment.IOS -> return api.getiOSData(page)
//            GirlFragment.GIRL -> return api.getGirlData(page)
            else -> return api.getAndroidData(page)
        }
    }
}
