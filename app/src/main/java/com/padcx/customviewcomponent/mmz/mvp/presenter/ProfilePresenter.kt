package com.padcx.customviewcomponent.mmz.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.padcx.customviewcomponent.mmz.delegates.PeopleListActionDelegate
import com.padcx.customviewcomponent.mmz.mvp.views.MainView
import com.padcx.customviewcomponent.mmz.mvp.views.ProfileView

/**
 * Created by Myint Myint Zaw on 7/26/2020.
 */
interface ProfilePresenter : BasePresenter<ProfileView>, PeopleListActionDelegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}