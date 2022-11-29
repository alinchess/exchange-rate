package com.example.kursvalut.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.kursvalut.R
import com.example.kursvalut.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_root.view.*

class RootFragment : Fragment() {
    private var ctx: Context? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_root, container, false)
        view.viewpager.adapter = ViewPagerAdapter(ctx as FragmentActivity)
        view.tab_layout.tabIconTint = null
        TabLayoutMediator(view.tab_layout, view.viewpager) { tab, pos ->
            when (pos) {
                0 -> tab.text = "mono"
                1 -> tab.text = "privat"
            }
        }.attach()


        return view
    }

}