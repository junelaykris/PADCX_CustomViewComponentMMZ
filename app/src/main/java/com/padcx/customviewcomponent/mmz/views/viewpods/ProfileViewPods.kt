package com.padcx.customviewcomponent.mmz.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.padcx.customviewcomponent.mmz.data.UserVO
import kotlinx.android.synthetic.main.profile_data_layout.view.*

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class ProfileViewPods @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    fun bindData(
        muser: UserVO?
    ) {
        tv_username.text = muser?.name
        txt_open_count.text = muser?.opentask_count
        txt_close_count.text = muser?.closedtask_count
        imgProfile.setImageResource(muser!!.imageurl)

    }

    private fun setUpListener() {
        iv_share.setOnClickListener {
            mDelegate?.onTapShare()
        }

        btn_message.setOnClickListener {
            mDelegate?.onTapMessage()
        }

        iv_chart.setOnClickListener {
            mDelegate?.onTapList()
        }

    }

    interface Delegate {
        fun onTapShare()
        fun onTapMessage()
        fun onTapList()
    }
}