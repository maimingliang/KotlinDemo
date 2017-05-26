package com.elk.kotlindemo

import android.content.Context
import android.widget.Toast

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

fun Context.getMainComponent() = App.instance.apiCompontent

fun Context.toast(msg: String,length: Int=Toast.LENGTH_SHORT){
    Toast.makeText(this, msg, length).show()

}
