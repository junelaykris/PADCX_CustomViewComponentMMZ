package com.padcx.customviewcomponent.mmz.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.padcx.customviewcomponent.mmz.delegates.PeopleListActionDelegate
import com.padcx.customviewcomponent.mmz.mvp.views.MainView

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
interface CreateTaskPresenter : BasePresenter<MainView>, PeopleListActionDelegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}
