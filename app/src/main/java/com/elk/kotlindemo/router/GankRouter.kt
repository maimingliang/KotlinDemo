package com.elk.kotlindemo.router

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 *
 * 类       名:
 * 说       明:
 * 修 改 记 录:
 * 版 权 所 有:   Copyright © 2017
 * 公       司:   深圳市旅联网络科技有限公司
 * version   0.1
 * date   2017/5/27
 * author   maimingliang
 */

object GankRouter{
    fun router(context: Context,uri: String){
        val intent = Intent()
        intent.data = Uri.parse(uri)
        intent.action = Intent.ACTION_VIEW
        context.startActivity(intent)
    }
}