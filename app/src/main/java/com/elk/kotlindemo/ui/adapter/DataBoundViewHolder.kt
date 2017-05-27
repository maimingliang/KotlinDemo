package com.elk.kotlindemo.ui.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

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

class DataBoundViewHolder<T: ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root) {
}