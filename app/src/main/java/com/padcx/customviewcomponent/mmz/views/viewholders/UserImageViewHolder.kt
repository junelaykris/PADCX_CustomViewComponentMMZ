package com.padcx.customviewcomponent.mmz.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.delegates.PeopleListActionDelegate
import kotlinx.android.synthetic.main.user_image_item.view.*
import kotlinx.android.synthetic.main.user_list_item.view.*

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class UserImageViewHolder(itemView: View, private val mDelegate: PeopleListActionDelegate) :
    BaseImageViewHolder(itemView) {

    init {
        itemView.roundedCornerImageView.setOnClickListener {
            mData?.let {
                mDelegate.onTap(it, itemView.roundedCornerImageView)
            }
        }
    }

    override fun bindData(data: UserVO) {
        mData = data
        itemView.roundedCornerImageView.setImageResource(data.imageurl)
    }
}