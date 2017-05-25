package com.elk.kotlindemo.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.elk.kotlindemo.R
import com.elk.kotlindemo.bean.FuckGoods
import com.elk.kotlindemo.databinding.ActivityMainBinding
import com.elk.kotlindemo.di.component.RandomModule
import com.elk.kotlindemo.getMainComponent
import com.elk.kotlindemo.mvp.contract.RandomContract

class MainActivity : BaseBindingActivity<ActivityMainBinding>(),RandomContract.View {



    override fun createBindingView(savedInstanceState: Bundle?): ActivityMainBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun initView() {

        initFragments()
        getMainComponent().plus(RandomModule(this)).inject(this)

    }

    private fun initFragments() {


    }


    override fun onRandom(goods: FuckGoods) {


    }
}
