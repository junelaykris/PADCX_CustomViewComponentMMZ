package com.padcx.customviewcomponent.mmz.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showDialog()
    }

    fun showSnackbar(message : String){
        Snackbar
            .make(window.decorView, message, Snackbar.LENGTH_LONG).show()
    }

    fun showDialog(){

    }

}