package com.elk.kotlindemo.ui.fragment

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.elk.kotlindemo.R
import com.elk.kotlindemo.bean.FuckGoods
import java.util.*

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

class AndroidFragment: BaseBingingFragment<ViewDataBinding>() {

    private var mList = ArrayList<FuckGoods>()

    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): ViewDataBinding {

        return DataBindingUtil.inflate(inflater, R.layout.view_recycler,container,false)
    }

    override fun initView() {
     }

    companion object{
        val ANDROID = "ANDROID"
        fun newInstance(): AndroidFragment{
            val fragment = AndroidFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
}