package com.example.viewpager.Adaptors.RecyclerViewAdapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.viewpager.MainActivity2
import com.example.viewpager.Model.RecyclerModel
import com.example.viewpager.R

class RecyclerAdapter(val data: List<RecyclerModel>,val callback:MyInterface) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recylerviewitemdesign, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position],callback)
        Log.d("mansoor","${data.size}")
    }
    override fun getItemCount() = data.size
}
class MyViewHolder(itemView:View) : ViewHolder(itemView) {
    var name = itemView.findViewById<TextView>(R.id.nameitem)
    var desc = itemView.findViewById<TextView>(R.id.descriptionitem)
    var price = itemView.findViewById<TextView>(R.id.priceitem)
    fun bind(data:RecyclerModel,callback:MyInterface) {
        name.text=data.name
        desc.text=data.descript
        price.text=data.price

        itemView.setOnClickListener{
            Log.d("mansoor","${data.name}")
            val intent=Intent(itemView.context,MainActivity2::class.java)
            itemView.context.startActivity(intent)
            callback.recyclerCallBack(adapterPosition)

        }
    }

}
