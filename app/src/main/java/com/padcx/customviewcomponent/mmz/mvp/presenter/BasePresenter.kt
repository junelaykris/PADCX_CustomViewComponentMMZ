package com.padcx.customviewcomponent.mmz.mvp.presenter

import com.padcx.customviewcomponent.mmz.mvp.views.BaseView

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
interface BasePresenter<T : BaseView> {
    fun initPresenter(view: T)
}