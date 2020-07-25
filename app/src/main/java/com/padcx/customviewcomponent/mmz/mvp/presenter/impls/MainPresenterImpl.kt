package com.padcx.customviewcomponent.mmz.mvp.presenter.impls

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.mvp.presenter.MainPresenter
import com.padcx.customviewcomponent.mmz.mvp.views.MainView

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class MainPresenterImpl : MainPresenter, BaseAppPresenterImpl<MainView>() {

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        mView?.displayPeopleList()
    }

    override fun onTap(entity: UserVO, profileImage: ImageView) {
        mView?.navigateToProfileScreen()
    }

    override fun onTapAddBtn() {
        mView?.navigateToCreateTask()
    }


}