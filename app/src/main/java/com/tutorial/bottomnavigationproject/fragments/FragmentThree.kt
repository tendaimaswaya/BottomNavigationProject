package com.tutorial.bottomnavigationproject.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tutorial.bottomnavigationproject.R
import kotlinx.android.synthetic.main.fragment_view.*

class FragmentThree : Fragment() {
    lateinit var rootView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_view,container,false)
        rootView.findViewById<TextView>(R.id.textView).setText("Fragment Three")

        return rootView
    }
}