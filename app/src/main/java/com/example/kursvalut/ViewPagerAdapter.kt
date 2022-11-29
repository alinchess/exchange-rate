package com.example.kursvalut

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kursvalut.screens.MonobankFragment
import com.example.kursvalut.screens.PrivatbankFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MonobankFragment()
            else -> PrivatbankFragment()

        }
    }
}