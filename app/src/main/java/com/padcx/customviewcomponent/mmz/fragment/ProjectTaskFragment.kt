package com.padcx.customviewcomponent.mmz.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.customviewcomponent.mmz.R
import com.padcx.customviewcomponent.mmz.adapters.ProjectTaskAdapter
import com.padcx.customviewcomponent.mmz.adapters.UserRecyclerAdatper
import com.padcx.customviewcomponent.mmz.data.UserVO
import com.padcx.customviewcomponent.mmz.mvp.presenter.ProfilePresenter
import com.padcx.customviewcomponent.mmz.mvp.presenter.impls.ProfilePresenterImpl
import com.padcx.customviewcomponent.mmz.mvp.views.ProfileView
import kotlinx.android.synthetic.main.fragment_tasks.*
import kotlinx.android.synthetic.main.fragment_tasks.view.*

/**
 * Created by Myint Myint Zaw on 7/26/2020.
 */
class ProjectTaskFragment : Fragment(), ProfileView {

    private lateinit var usertaskAdapter: ProjectTaskAdapter
    private lateinit var mPresenter: ProfilePresenter
    val tasklist: ArrayList<UserVO> = arrayListOf()

    companion object {
        var mcontext: Context? = null
        fun newInstance(context: Context): ProjectTaskFragment {
            mcontext = context
            return ProjectTaskFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tasks, container, false)
        setUpPresenter()
        setUpUI(view)
        mPresenter.onUiReady(this)
        return view
    }

    private fun setUpUI(view: View) {
        usertaskAdapter = ProjectTaskAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(mcontext, LinearLayoutManager.VERTICAL, false)
        view.rv_usertask.layoutManager = linearLayoutManager
        view.rv_usertask.adapter = usertaskAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ProfilePresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun displayPeopleList() {
        tasklist.add(
            UserVO(
                "In Progress", "Damon", "Contact Page",
                R.drawable.userone, 3, 5, "1h", "201", "3"
            )
        )

        tasklist.add(
            UserVO(
                "In Progress", "Suzan", "Create Mobile Version",
                R.drawable.userone, 15, 9, "3h", "241", "5"
            )
        )

        tasklist.add(
            UserVO(
                "Done", "Arthur Chen", "Buttons,Pop-Up",
                R.drawable.userone, 4, 8, "1d 5h", "355", "2"
            )
        )
        usertaskAdapter.setNewData(tasklist)
    }

    override fun navigateToProfileScreen() {

    }

    override fun navigateToCreateTask() {
    }

}