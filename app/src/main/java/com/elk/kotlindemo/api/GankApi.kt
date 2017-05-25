package com.elk.kotlindemo.api

import com.elk.kotlindemo.bean.FuckGoods
import com.elk.kotlindemo.mvp.contract.JsonResult
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 *
 * 类       名:
 * 说       明:
 * 修 改 记 录:
 * 版 权 所 有:   Copyright © 2017
 * 公       司:   深圳市旅联网络科技有限公司
 * version   0.1
 * date   2017/5/24
 * author   maimingliang
 */
interface GankApi{

    /**
     * 手气不错
     */
    @GET("random/data/{type}/1")
    fun getRandom(@Path("path") type: String): Observable<JsonResult<List<FuckGoods>>>
}

