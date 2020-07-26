package com.padcx.customviewcomponent.mmz.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.customviewcomponent.mmz.R
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.delegates.PeopleListActionDelegate
import com.padcx.customviewcomponent.mmz.views.viewholders.UserViewHolder

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class UserRecyclerAdatper(private val mDelegate : PeopleListActionDelegate) :
    BaseRecyclerAdapter<UserViewHolder,UserVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item,parent,false)
        return UserViewHolder(view, mDelegate)
    }
}