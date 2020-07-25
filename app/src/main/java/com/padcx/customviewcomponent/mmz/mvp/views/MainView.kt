package com.padcx.customviewcomponent.mmz.mvp.views

import com.padcx.customviewcomponent.mmz.data.UserVO

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
interface MainView : BaseView{
    fun displayPeopleList()
    fun navigateToProfileScreen()
    fun navigateToCreateTask()
}