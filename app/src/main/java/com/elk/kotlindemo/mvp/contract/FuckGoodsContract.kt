package com.elk.kotlindemo.mvp.contract

import com.elk.kotlindemo.bean.FuckGoods
import com.elk.kotlindemo.bean.JsonResult
import rx.Observable

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

interface FuckGoodsContract {
    interface View {
        fun  setData(results: List<FuckGoods>)

    }

    interface Model {

        fun getData(page: Int,type:String): Observable<JsonResult<List<FuckGoods>>>
    }

    interface Presenter {

        open fun getData(page: Int, type: String)
    }
}