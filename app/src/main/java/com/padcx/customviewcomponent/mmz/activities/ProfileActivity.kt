package com.padcx.customviewcomponent.mmz.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.padcx.customviewcomponent.mmz.R
import com.padcx.customviewcomponent.mmz.adapters.TaskAdpater
import kotlinx.android.synthetic.main.create_task_layout.*
import kotlinx.android.synthetic.main.create_task_toolbar.*
import kotlinx.android.synthetic.main.create_task_toolbar.view.*
import kotlinx.android.synthetic.main.main_custom_actionbar.*
import kotlinx.android.synthetic.main.main_custom_actionbar.view.*
import kotlinx.android.synthetic.main.profile_layout.*

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class ProfileActivity:AppCompatActivity(){
    lateinit var vptaskAdapter: TaskAdpater
    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ProfileActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_layout)

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

        appBarLayout.button.visibility=View.GONE

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}