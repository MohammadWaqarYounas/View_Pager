package com.example.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){

    private val fragmentlist : MutableList<Fragment> = ArrayList()
    private val titlelist : MutableList<String> = ArrayList()

    override fun getCount(): Int {
        return fragmentlist.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentlist[position]
    }
    fun addFragment(fragment: Fragment,title:String){
        fragmentlist.add(fragment)
        titlelist.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titlelist[position]
    }

}