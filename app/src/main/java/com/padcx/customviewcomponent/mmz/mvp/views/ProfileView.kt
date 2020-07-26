package com.padcx.customviewcomponent.mmz.mvp.views

import com.padcx.customviewcomponent.mmz.data.UserVO

/**
 * Created by Myint Myint Zaw on 7/26/2020.
 */
interface ProfileView : BaseView{
    fun displayPeopleList()
    fun navigateToProfileScreen()
    fun navigateToCreateTask()
}