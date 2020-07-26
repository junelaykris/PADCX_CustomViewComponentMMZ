package com.padcx.customviewcomponent.mmz.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.customviewcomponent.mmz.R
import com.padcx.customviewcomponent.mmz.adapters.UserImageRecyclerAdatper
import com.padcx.customviewcomponent.mmz.adapters.UserRecyclerAdatper
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.mvp.presenter.MainPresenter
import com.padcx.customviewcomponent.mmz.mvp.presenter.impls.MainPresenterImpl
import com.padcx.customviewcomponent.mmz.mvp.views.MainView
import com.padcx.customviewcomponent.mmz.util.OverlapDecoration
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_gp_layout.*
import kotlinx.android.synthetic.main.user_gp_layout.view.*


class MainActivity : AppCompatActivity(), MainView {

    private lateinit var muserAdapter: UserRecyclerAdatper
    private lateinit var muserimageAdapter: UserImageRecyclerAdatper
    private lateinit var mPresenter: MainPresenter
    val userlist: ArrayList<UserVO> = arrayListOf()
    val userimglist: ArrayList<UserVO> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        setUpUI()
        setUpListeners()
        mPresenter.onUiReady(this)
    }

    private fun setUpListeners() {
        // mPresenter.onTapAddBtn()
        /*  addbtn.setOnClickListener {
              mPresenter.onTapAddBtn()
          }*/
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpUI() {
        circularprogressbar.setProgressColor(getResources().getColor(R.color.colorPrimary));
        circularprogressbar.setProgressWidth(10.toFloat())
         circularprogressbar.setProgress(85)

        muserAdapter = UserRecyclerAdatper(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_user.layoutManager = linearLayoutManager
        rv_user.adapter = muserAdapter

        muserimageAdapter = UserImageRecyclerAdatper(mPresenter)
        val mlinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        iv_recycler.rv_createuser.layoutManager = mlinearLayoutManager
        iv_recycler.rv_createuser.adapter = muserimageAdapter
        iv_recycler.rv_createuser.addItemDecoration(OverlapDecoration())

    }

    override fun displayPeopleList() {
        userlist.add(
            UserVO(
                "In Progress", "Damon", "Contact Page",
                R.drawable.userone, 3, 5, "#Desgin", "201", "3"
            )
        )

        userlist.add(
            UserVO(
                "Done", "Suzan", "Calculator Page",
                R.drawable.usertwo, 8, 2, "#Design", "241", "5"
            )
        )

        userlist.add(
            UserVO(
                "Review", "Arthur Chen", "Technical task",
                R.drawable.userthree, 4, 8, "#Frontend", "355", "2"
            )
        )

        muserAdapter.setNewData(userlist)


        userimglist.add(
            UserVO(imageurl = R.drawable.userone,name = "Damon",closedtask_count ="201" ,opentask_count ="3" )
        )

        userimglist.add(
            UserVO(imageurl = R.drawable.usertwo,name = "Suzan",closedtask_count ="241" ,opentask_count ="5" )
        )

        userimglist.add(
            UserVO(imageurl = R.drawable.userthree,name = "Arthur Chen",closedtask_count ="355" ,opentask_count ="2" )
        )

        userimglist.add(
            UserVO(imageurl = R.drawable.plus)
        )

        muserimageAdapter.setNewData(userimglist)
    }

    override fun navigateToProfileScreen(user: UserVO) {
        startActivity(ProfileActivity.newIntent(this, user))
    }

    override fun navigateToCreateTask() {
        startActivity(CreateTaskActivity.newIntent(this))
    }
}