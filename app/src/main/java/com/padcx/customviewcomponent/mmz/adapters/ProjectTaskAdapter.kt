package com.padcx.customviewcomponent.mmz.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.customviewcomponent.mmz.R
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.delegates.PeopleListActionDelegate
import com.padcx.customviewcomponent.mmz.views.viewholders.ProjectTaskViewHolder

/**
 * Created by Myint Myint Zaw on 7/26/2020.
 */
class ProjectTaskAdapter(private val mDelegate : PeopleListActionDelegate) :
    BaseRecyclerAdapter<ProjectTaskViewHolder, UserVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectTaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item,parent,false)
        return ProjectTaskViewHolder(view, mDelegate)
    }
}