package com.padcx.customviewcomponent.mmz.mvp.presenter.impls

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.mvp.presenter.ProfilePresenter
import com.padcx.customviewcomponent.mmz.mvp.views.ProfileView

/**
 * Created by Myint Myint Zaw on 7/26/2020.
 */
class ProfilePresenterImpl : ProfilePresenter, BaseAppPresenterImpl<ProfileView>() {

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        mView?.displayPeopleList()
    }

    override fun onTap(user: UserVO, profileImage: ImageView) {

    }


    override fun onTapAddBtn() {
        mView?.navigateToCreateTask()
    }
}

