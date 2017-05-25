package com.elk.kotlindemo.ui.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

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
class NoScrollViewPager : ViewPager{


    private val isPagingEnabled = false

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context,attrs)

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return this.isPagingEnabled && super.onTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return this.isPagingEnabled && super.onInterceptTouchEvent(ev)
    }

    override fun scrollTo(x: Int, y: Int) {
        super.scrollTo(x, y)
    }
}
