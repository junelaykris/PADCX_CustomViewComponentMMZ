package com.padcx.customviewcomponent.mmz.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.padcx.customviewcomponent.mmz.R

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class AboutFragment : Fragment() {

    companion object {
        fun newInstance(context: Context): AboutFragment {
            return AboutFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        return view
    }
}