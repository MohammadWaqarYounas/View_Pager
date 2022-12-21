package com.example.viewpager

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private val galleryLaunch=registerForActivityResult(ActivityResultContracts.GetMultipleContents()){

    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        val adaptor =ViewPagerAdapter(supportFragmentManager)
        adaptor.addFragment(FragmentOne(),"One")
        adaptor.addFragment(FragmentTwo(),"Two")
        adaptor.addFragment(FragmentThree(),"Three")
        binding.viewpager.adapter=adaptor
        binding.tablayout.setupWithViewPager(binding.viewpager)


        val context:Context=this
        val activity:Activity=this

    }
}