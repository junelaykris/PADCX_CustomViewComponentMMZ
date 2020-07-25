package com.padcx.customviewcomponent.mmz.mvp.presenter

import androidx.lifecycle.ViewModel
import com.padcx.customviewcomponent.mmz.mvp.views.BaseView

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}