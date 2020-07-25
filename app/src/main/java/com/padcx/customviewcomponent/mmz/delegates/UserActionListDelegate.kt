package com.padcx.customviewcomponent.mmz.delegates

import android.widget.ImageView
import com.padcx.customviewcomponent.mmz.data.UserVO

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
interface PeopleListActionDelegate {
    fun onTap(user : UserVO, profileImage: ImageView)
    fun onTapAddBtn()
}