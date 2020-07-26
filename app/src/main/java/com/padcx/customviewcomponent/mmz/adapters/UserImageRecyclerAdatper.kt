package com.padcx.customviewcomponent.mmz.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.customviewcomponent.mmz.R
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.delegates.PeopleListActionDelegate
import com.padcx.customviewcomponent.mmz.views.viewholders.BaseImageViewHolder
import com.padcx.customviewcomponent.mmz.views.viewholders.CreateUserImageViewHolder
import com.padcx.customviewcomponent.mmz.views.viewholders.UserImageViewHolder

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class UserImageRecyclerAdatper(private val mDelegate: PeopleListActionDelegate) :
    BaseRecyclerAdapter<BaseImageViewHolder, UserVO>() {
    val VIEW_TYPE_IMAGE = 1005
    val VIEW_TYPE_ADD = 805

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseImageViewHolder {
        when (viewType) {
            VIEW_TYPE_ADD -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.create_user_item, parent, false)
                return CreateUserImageViewHolder(view, mDelegate)
            }
            VIEW_TYPE_IMAGE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.user_image_item, parent, false)
                return UserImageViewHolder(view, mDelegate)
            }
            else -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.create_user_item, parent, false)
                return CreateUserImageViewHolder(view, mDelegate)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        when {
            position == mData.size - 1 -> {
                return VIEW_TYPE_ADD
            }
            else -> {
                return VIEW_TYPE_IMAGE
            }
        }
    }


}