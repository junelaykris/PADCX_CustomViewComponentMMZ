package com.padcx.customviewcomponent.mmz.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.customviewcomponent.mmz.R
import com.padcx.customviewcomponent.mmz.adapters.UserImageRecyclerAdatper
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.mvp.presenter.CreateTaskPresenter
import com.padcx.customviewcomponent.mmz.mvp.presenter.MainPresenter
import com.padcx.customviewcomponent.mmz.mvp.presenter.impls.CreateTaskPresenterImpl
import com.padcx.customviewcomponent.mmz.mvp.presenter.impls.MainPresenterImpl
import com.padcx.customviewcomponent.mmz.mvp.views.MainView
import com.padcx.customviewcomponent.mmz.util.OverlapDecoration
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.button_layout.view.*
import kotlinx.android.synthetic.main.create_task_layout.*
import kotlinx.android.synthetic.main.create_task_toolbar.*
import kotlinx.android.synthetic.main.create_task_toolbar.view.*
import kotlinx.android.synthetic.main.user_gp_layout.*
import kotlinx.android.synthetic.main.user_gp_layout.view.*

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class CreateTaskActivity : AppCompatActivity(), MainView {
    private lateinit var mPresenter: CreateTaskPresenter
    private lateinit var mimageAdapter: UserImageRecyclerAdatper
    val imglist: ArrayList<UserVO> = arrayListOf()

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CreateTaskActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_task_layout)
        setUpPresenter()
        setUpUI()
        mPresenter.onUiReady(this)
        backtext.setOnClickListener { onBackPressed() }
        toolbar.save_btn.setOnClickListener {
            finish()
        }
    }

    private fun setUpUI() {
        rv_createtask.circularprogressbar.visibility = View.GONE
        mimageAdapter = UserImageRecyclerAdatper(mPresenter)
        val mlinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_createtask.rv_createuser.layoutManager = mlinearLayoutManager
        rv_createtask.rv_createuser.adapter = mimageAdapter
        rv_createtask.rv_createuser.addItemDecoration(OverlapDecoration())

        displayTeamList()

        layout_btn.btn_design.setOnClickListener {
            layout_btn.btn_design.setBackgroundResource(R.drawable.rounded_greenbg)
            layout_btn.btn_design.setTextColor(ContextCompat.getColor(this,R.color.color_white))
            layout_btn.btn_design.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_check_24, 0, 0, 0);

            layout_btn.btn_front.setBackgroundResource(R.drawable.rounded_whitebg)
            layout_btn.btn_front.setTextColor(ContextCompat.getColor(this,R.color.color_black))
            layout_btn.btn_front.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

            layout_btn.btn_backend.setBackgroundResource(R.drawable.rounded_whitebg)
            layout_btn.btn_backend.setTextColor(ContextCompat.getColor(this,R.color.color_black))
            layout_btn.btn_backend.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }

        layout_btn.btn_front.setOnClickListener {
            layout_btn.btn_front.setBackgroundResource(R.drawable.rounded_greenbg)
            layout_btn.btn_front.setTextColor(ContextCompat.getColor(this,R.color.color_white))
            layout_btn.btn_front.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_check_24, 0, 0, 0);

            layout_btn.btn_design.setBackgroundResource(R.drawable.rounded_whitebg)
            layout_btn.btn_design.setTextColor(ContextCompat.getColor(this,R.color.color_black))
            layout_btn.btn_design.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

            layout_btn.btn_backend.setBackgroundResource(R.drawable.rounded_whitebg)
            layout_btn.btn_backend.setTextColor(ContextCompat.getColor(this,R.color.color_black))
            layout_btn.btn_backend.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }

        layout_btn.btn_backend.setOnClickListener {
            layout_btn.btn_backend.setBackgroundResource(R.drawable.rounded_greenbg)
            layout_btn.btn_backend.setTextColor(ContextCompat.getColor(this,R.color.color_white))
            layout_btn.btn_backend.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_check_24, 0, 0, 0);

            layout_btn.btn_design.setBackgroundResource(R.drawable.rounded_whitebg)
            layout_btn.btn_design.setTextColor(ContextCompat.getColor(this,R.color.color_black))
            layout_btn.btn_design.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

            layout_btn.btn_front.setBackgroundResource(R.drawable.rounded_whitebg)
            layout_btn.btn_front.setTextColor(ContextCompat.getColor(this,R.color.color_black))
            layout_btn.btn_front.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private fun displayTeamList() {
        imglist.add(
            UserVO(imageurl = R.drawable.userone,name = "Damon",closedtask_count ="201" ,opentask_count ="3" )
        )

        imglist.add(
            UserVO(imageurl = R.drawable.usertwo,name = "Suzan",closedtask_count ="241" ,opentask_count ="5" )
        )

        imglist.add(
            UserVO(imageurl = R.drawable.plus)
        )

        mimageAdapter.setNewData(imglist)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(CreateTaskPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun displayPeopleList() {
    }

    override fun navigateToProfileScreen(user: UserVO) {
        startActivity(ProfileActivity.newIntent(this, user))
    }

    override fun navigateToCreateTask() {
    }
}