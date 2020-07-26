package com.padcx.customviewcomponent.mmz.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.delegates.PeopleListActionDelegate
import kotlinx.android.synthetic.main.create_user_item.view.*
import kotlinx.android.synthetic.main.user_image_item.view.*
import kotlinx.android.synthetic.main.user_list_item.view.*

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class CreateUserImageViewHolder(itemView: View, private val mDelegate: PeopleListActionDelegate) :
    BaseImageViewHolder(itemView) {

    init {
        itemView.addbtn.setOnClickListener {
            mData?.let {
                mDelegate.onTapAddBtn()
            }
        }
    }

    override fun bindData(data: UserVO) {
        mData = data
       // itemView.addbtn.setImageResource(data.imageurl)
    }
}