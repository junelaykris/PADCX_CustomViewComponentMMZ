package com.padcx.customviewcomponent.mmz.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.padcx.customviewcomponent.mmz.fragment.AboutFragment
import com.padcx.customviewcomponent.mmz.fragment.ContactsFragment
import com.padcx.customviewcomponent.mmz.fragment.ProjectTaskFragment

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class TaskAdpater(val context: Context, val fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var mContext = context
    private val NUM_ITEMS = 3

    val titleList = arrayListOf("Project Tasks", "Contacts","About You")
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return ProjectTaskFragment.newInstance(mContext)
            }
            1 -> {
                return ContactsFragment.newInstance(mContext)
            }
            2-> {
                return AboutFragment.newInstance(mContext)
            }
            else -> {
                return ProjectTaskFragment.newInstance(mContext)

            }
        }

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }


    override fun getCount(): Int {
        return NUM_ITEMS
    }
}