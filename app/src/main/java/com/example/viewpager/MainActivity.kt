package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var tabs: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adaptor =ViewPagerAdapter(supportFragmentManager)
        adaptor.addFragment(FragmentOne(),"One")
        adaptor.addFragment(FragmentTwo(),"Two")
        adaptor.addFragment(FragmentThree(),"Three")
        viewPager=findViewById(R.id.viewpager)
        tabs=findViewById(R.id.tablayout)
        viewPager.adapter=adaptor
        tabs.setupWithViewPager(viewPager)


    }
}