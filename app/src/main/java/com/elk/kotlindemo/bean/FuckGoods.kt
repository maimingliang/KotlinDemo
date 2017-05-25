package com.elk.kotlindemo.bean

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

data class FuckGoods(
        val _id: String,
        val createAt: String,
        val desc: String,
        val images: Array<String>,
        val publishedAt: String,
        val source: String,
        val type: String,
        val url: String,
        val used: Boolean,
        val who: String
){
    fun hasImg(): Boolean{
        return images != null
    }

    fun create() = createAt.substring(0, 10)


}