package com.elk.kotlindemo.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.elk.kotlindemo.R
import com.elk.kotlindemo.bean.FuckGoods
import com.elk.kotlindemo.databinding.ActivityMainBinding
import com.elk.kotlindemo.di.component.RandomModule
import com.elk.kotlindemo.getMainComponent
import com.elk.kotlindemo.mvp.contract.RandomContract
import com.elk.kotlindemo.mvp.presenter.RandomPresenter
import com.elk.kotlindemo.router.GankClientUri
import com.elk.kotlindemo.router.GankRouter
import com.elk.kotlindemo.toast
import com.elk.kotlindemo.ui.fragment.AndroidFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URLEncoder
import java.util.*
import javax.inject.Inject

class MainActivity : BaseBindingActivity<ActivityMainBinding>(), RandomContract.View {


    @Inject
    lateinit var mPresenter: RandomPresenter
    lateinit var mFragments: MutableList<Fragment>

    override fun createBindingView(savedInstanceState: Bundle?): ActivityMainBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun initView() {

        initFragments()
        getMainComponent().plus(RandomModule(this)).inject(this)
        view_pager.adapter = object: FragmentPagerAdapter(supportFragmentManager){
            override fun getItem(position: Int): Fragment = mFragments.get(position)

            override fun getCount(): Int = mFragments.size

        }

        view_pager.offscreenPageLimit = 4
        navigation_view.setOnNavigationItemSelectedListener { item ->

            var tab = 0

            when(item.itemId){
                R.id.menu_android -> tab = 0
                R.id.menu_ios -> tab = 1
                R.id.menu_girl -> tab = 2
                R.id.menu_about -> tab = 3
             }
            view_pager.currentItem = tab

            false
        }

        floatingButton.setOnClickListener { mPresenter.getRandom("Android") }


    }

    private fun initFragments() {
        mFragments = ArrayList()
        mFragments.add(AndroidFragment.newInstance())
        mFragments.add(AndroidFragment.newInstance())
        mFragments.add(AndroidFragment.newInstance())
        mFragments.add(AndroidFragment.newInstance())


    }


    override fun onRandom(goods: FuckGoods) {

        val url = URLEncoder.encode(goods.url)
        toast("手气不错")
        GankRouter.router(this,GankClientUri.DETAIL+url)

    }
}
