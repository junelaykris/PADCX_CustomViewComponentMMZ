package com.padcx.customviewcomponent.mmz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.customviewcomponent.mmz.R
import com.padcx.customviewcomponent.mmz.adapters.UserRecyclerAdatper
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.mvp.presenter.MainPresenter
import com.padcx.customviewcomponent.mmz.mvp.presenter.impls.MainPresenterImpl
import com.padcx.customviewcomponent.mmz.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_gp_layout.*

class MainActivity : AppCompatActivity(),MainView{

    private lateinit var muserAdapter: UserRecyclerAdatper
    private lateinit var mPresenter: MainPresenter
    val userlist: ArrayList<UserVO> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        setUpUI()
        setUpListeners()
        mPresenter.onUiReady(this)
    }

    private fun setUpListeners() {
        addbtn.setOnClickListener {
            mPresenter.onTapAddBtn()
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpUI() {
        circularprogressbar.setProgressColor(getResources().getColor(R.color.colorPrimary));
        circularprogressbar.setProgressWidth(10)
        circularprogressbar.setProgress(85)

        muserAdapter = UserRecyclerAdatper(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_user.layoutManager = linearLayoutManager
        rv_user.adapter = muserAdapter

    }

    override fun displayPeopleList() {
        userlist.add(
            UserVO("In Progress","#Desgin","Contact Page",
               R.drawable.userone,3,5))

        userlist.add(
            UserVO("Done","#Desgin","Calculator Page",
                R.drawable.usertwo,8,2))

        userlist.add(
            UserVO("Review","#Desgin","Technical task",
                R.drawable.userthree,4,8))
        muserAdapter.setNewData(userlist)
    }

    override fun navigateToProfileScreen() {
      startActivity(ProfileActivity.newIntent(this))
    }

    override fun navigateToCreateTask() {
        startActivity(CreateTaskActivity.newIntent(this))
    }
}