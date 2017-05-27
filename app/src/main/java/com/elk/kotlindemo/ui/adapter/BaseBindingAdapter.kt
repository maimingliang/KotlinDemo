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

abstract class BaseBindingAdapter<B: ViewDataBinding> : RecyclerView.Adapter<DataBoundViewHolder<B>>() {

    var mListener: ((pos: Int) -> Unit)? = null


    override fun onBindViewHolder(holder: DataBoundViewHolder<B>?, position: Int) {
        holder?.binding?.root?.setOnClickListener {
            mListener?.invoke(holder.adapterPosition)
        }
    }
    fun setOnItemListener(listener: ((pos: Int) -> Unit)){
        mListener = listener
    }
}