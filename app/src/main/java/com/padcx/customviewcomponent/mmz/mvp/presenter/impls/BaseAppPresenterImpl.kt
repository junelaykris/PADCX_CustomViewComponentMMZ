package com.padcx.customviewcomponent.mmz.mvp.presenter.impls

import com.padcx.customviewcomponent.mmz.mvp.presenter.AbstractBasePresenter
import com.padcx.customviewcomponent.mmz.mvp.presenter.BasePresenter
import com.padcx.customviewcomponent.mmz.mvp.views.BaseView

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
abstract class BaseAppPresenterImpl<V : BaseView> : AbstractBasePresenter<V>(), BasePresenter<V>