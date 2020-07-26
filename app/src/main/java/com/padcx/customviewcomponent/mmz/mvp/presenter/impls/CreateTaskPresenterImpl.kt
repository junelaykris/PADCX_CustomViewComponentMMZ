package com.padcx.customviewcomponent.mmz.mvp.presenter.impls

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.mvp.presenter.CreateTaskPresenter
import com.padcx.customviewcomponent.mmz.mvp.presenter.MainPresenter
import com.padcx.customviewcomponent.mmz.mvp.views.MainView

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class CreateTaskPresenterImpl : CreateTaskPresenter, BaseAppPresenterImpl<MainView>()  {
    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
    }

    override fun onTap(user: UserVO, profileImage: ImageView) {
        mView?.navigateToProfileScreen(user)
    }

    override fun onTapAddBtn() {
    }
}