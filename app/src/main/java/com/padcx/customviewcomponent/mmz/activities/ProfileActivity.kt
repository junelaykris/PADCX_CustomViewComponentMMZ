package com.padcx.customviewcomponent.mmz.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.TouchDelegate
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.padcx.customviewcomponent.mmz.R
import com.padcx.customviewcomponent.mmz.adapters.TaskAdpater
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.views.viewpods.ProfileViewPods
import kotlinx.android.synthetic.main.main_custom_actionbar.view.*
import kotlinx.android.synthetic.main.profile_layout.*

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class ProfileActivity : AppCompatActivity(), ProfileViewPods.Delegate {
    lateinit var vptaskAdapter: TaskAdpater

    lateinit var mViewPodReaction:ProfileViewPods
    lateinit var mDelegate: ProfileViewPods.Delegate

    companion object {
        var muser: UserVO? = null
        fun newIntent(
            context: Context,
            user: UserVO
        ): Intent {
            muser=user
            return Intent(context, ProfileActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_layout)

        mDelegate=this
        mViewPodReaction =profileviewpod as ProfileViewPods

        vptaskAdapter = TaskAdpater(
            this,
            supportFragmentManager
        )
        vp_tasks.adapter = vptaskAdapter
        tab_tasks.setupWithViewPager(vp_tasks)

        appBarLayout.iv_back.setOnClickListener {
            onBackPressed()
            finish()
        }

        appBarLayout.txt_toolbar.setText("Profile")
        appBarLayout.button.visibility = View.GONE

        mViewPodReaction.bindData(muser)
        mViewPodReaction.setDelegate(mDelegate)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onTapShare() {
        Toast.makeText(this,"onTapShare",Toast.LENGTH_SHORT).show()
    }

    override fun onTapMessage() {
        Toast.makeText(this,"onTapMessage",Toast.LENGTH_SHORT).show()
    }

    override fun onTapList() {
        Toast.makeText(this,"onTapList",Toast.LENGTH_SHORT).show()
    }

}