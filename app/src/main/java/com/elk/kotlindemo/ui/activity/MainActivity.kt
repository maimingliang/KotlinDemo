package com.elk.kotlindemo.ui.activity

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import com.elk.kotlindemo.R
import com.elk.kotlindemo.bean.FuckGoods
import com.elk.kotlindemo.di.component.RandomModule
import com.elk.kotlindemo.getMainComponent
import com.elk.kotlindemo.mvp.contract.RandomContract
import com.elk.kotlindemo.mvp.presenter.RandomPresenter
import javax.inject.Inject

class MainActivity : BaseBindingActivity<ViewDataBinding>(), RandomContract.View {


    @Inject lateinit var mPresenter: RandomPresenter

    override fun createBindingView(savedInstanceState: Bundle?): ViewDataBinding {
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
