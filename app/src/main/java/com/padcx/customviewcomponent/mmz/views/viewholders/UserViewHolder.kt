package com.padcx.customviewcomponent.mmz.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.delegates.PeopleListActionDelegate
import kotlinx.android.synthetic.main.user_list_item.view.*

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class UserViewHolder(itemView: View, private val mDelegate: PeopleListActionDelegate) :
    BaseViewHolder<UserVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTap(it, itemView.imageitem)
            }
        }

        itemView.imageitem.setOnClickListener {
            mData?.let {
                mDelegate.onTap(it, itemView.imageitem)
            }
        }
    }

    override fun bindData(data: UserVO) {
        mData = data

        itemView.status.text = data.status
        itemView.tv_jobtypeorhr.text = data.jobtype
        itemView.title.text = data.title
        itemView.chatcount.text = data.messagecount.toString()
        itemView.attachcount.text = data.attachment.toString()
        itemView.imageitem.setImageResource(data.imageurl)

    }
}