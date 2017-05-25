package com.elk.kotlindemo.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.elk.kotlindemo.R
import com.elk.kotlindemo.databinding.ActivityMainBinding

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {



    override fun createBindingView(savedInstanceState: Bundle?): ActivityMainBinding {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
