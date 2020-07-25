package com.padcx.customviewcomponent.mmz.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padcx.customviewcomponent.mmz.R
import kotlinx.android.synthetic.main.create_task_layout.*
import kotlinx.android.synthetic.main.create_task_toolbar.*
import kotlinx.android.synthetic.main.create_task_toolbar.view.*

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class CreateTaskActivity:AppCompatActivity() {
    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CreateTaskActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_task_layout)
        backtext.setOnClickListener { onBackPressed() }
        toolbar.save_btn.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}