package com.elk.kotlindemo.ui.adapter

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.elk.kotlindemo.R
import com.elk.kotlindemo.bean.FuckGoods
import com.elk.kotlindemo.databinding.ItemFuckgoodsBinding

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

class FuckGoodsAdapter(private val mList: List<FuckGoods>) : BaseBindingAdapter<ItemFuckgoodsBinding>() {
    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<ItemFuckgoodsBinding>?, position: Int) {
        super.onBindViewHolder(holder, position)
        holder?.binding?.fuckgoods = mList.get(position)
        holder?.binding?.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DataBoundViewHolder<ItemFuckgoodsBinding> {

        return DataBoundViewHolder(DataBindingUtil
                .inflate(LayoutInflater.from(parent?.context),R.layout.item_fuckgoods,parent,false))

    }


}