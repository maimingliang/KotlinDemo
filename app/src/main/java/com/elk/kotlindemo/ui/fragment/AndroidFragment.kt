package com.elk.kotlindemo.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.elk.kotlindemo.R
import com.elk.kotlindemo.bean.FuckGoods
import com.elk.kotlindemo.databinding.ViewRecyclerBinding
import com.elk.kotlindemo.di.component.FuckGoodsModule
import com.elk.kotlindemo.getMainComponent
import com.elk.kotlindemo.mvp.contract.FuckGoodsContract
import com.elk.kotlindemo.mvp.presenter.FuckGoodsPresenter
import com.elk.kotlindemo.router.GankClientUri
import com.elk.kotlindemo.router.GankRouter
import com.elk.kotlindemo.ui.adapter.FuckGoodsAdapter
import java.net.URLEncoder
import java.util.*
import javax.inject.Inject

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
class AndroidFragment: BaseBingingFragment<ViewRecyclerBinding>() , FuckGoodsContract.View{


    private var mList = ArrayList<FuckGoods>()
    private lateinit var mAdapter: FuckGoodsAdapter
    @Inject lateinit var mPresenter: FuckGoodsPresenter
    private var page = 1
    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): ViewRecyclerBinding {

         return DataBindingUtil.inflate(inflater, R.layout.view_recycler,container,false)
    }

    override fun initView() {
        mAdapter = FuckGoodsAdapter(mList)
        context.getMainComponent().plus(FuckGoodsModule(this)).inject(this)


        with(mBinding!!){
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(context)

            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if(!recyclerView?.canScrollVertically(1)!!){
                        mPresenter.getData(++page, ANDROID)
                    }
                }
            })


        }

        mPresenter.getData(page, ANDROID)

        mAdapter.setOnItemListener { pos ->
            var url = URLEncoder.encode(mList.get(pos).url)
            GankRouter.router(context,GankClientUri.DETAIL+url)
        }

     }

    override fun setData(results: List<FuckGoods>) {
        mList.addAll(results)
        mAdapter.notifyDataSetChanged()

    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unSubscription()
    }

    companion object{
        val ANDROID = "Android"
        fun newInstance(): AndroidFragment{
            val fragment = AndroidFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
}