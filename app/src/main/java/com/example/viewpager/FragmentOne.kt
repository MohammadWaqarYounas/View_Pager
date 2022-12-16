package com.example.viewpager

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager.Adaptors.RecyclerViewAdapter.MyInterface
import com.example.viewpager.Adaptors.RecyclerViewAdapter.RecyclerAdapter
import com.example.viewpager.Adaptors.RecyclerViewAdapter.RecyclerAdapter2
import com.example.viewpager.Model.RecyclerModel

class FragmentOne : Fragment() ,MyInterface {

    lateinit var image: ImageView
    lateinit var recView: RecyclerView
    lateinit var AdapterOne: RecyclerAdapter
    lateinit var listAdapterTemp: RecyclerAdapter2
    lateinit var myInterface: MyInterface
    lateinit var purchasesAPI:String


    override fun recyclerCallBack(position:Int) {
       // Log.d("waqar","My message")
        purchasesAPI="called"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        image = view.findViewById(R.id.iv_imageview)
        image.setImageResource(R.drawable.download1)
        recView = view.findViewById(R.id.rv_recylerview)
        val listOfData = populateData()



        val adapterPosition:Int
        myInterface=this
        AdapterOne = RecyclerAdapter(listOfData,myInterface)

        listAdapterTemp= RecyclerAdapter2(listOfData)


        {
            requireActivity().run {
            val intent=Intent(this,MainActivity2::class.java)
           // intent.putExtra("name","mansoor")
            startActivity(intent) }
        }

        recView.layoutManager=LinearLayoutManager(requireContext())
        recView.adapter=AdapterOne

    }

    fun populateData(): List<RecyclerModel> {
        val dataList = mutableListOf<RecyclerModel>()

        for (i in 0..10) {
            var data = RecyclerModel("mansoor $i", "description $i", "Price $i")
            dataList.add(data)
        }
        return dataList
    }
}