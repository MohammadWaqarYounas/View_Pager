package com.example.viewpager.Adaptors.RecyclerViewAdapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.viewpager.Model.RecyclerModel
import com.example.viewpager.R
class RecyclerAdapter2(private val data: List<RecyclerModel>, private var onClick:(position:Int)->Unit) : Adapter<MyViewHolderTemp>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderTemp {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recylerviewitemdesign, parent, false)
        return MyViewHolderTemp(view)
    }
    override fun onBindViewHolder(holder: MyViewHolderTemp, position: Int) {
        holder.bind(data[position],onClick)
        //Log.d("mansoor","${data.size}")
    }
    override fun getItemCount() = data.size
}
class MyViewHolderTemp(itemView:View) : ViewHolder(itemView) {
    var name = itemView.findViewById<TextView>(R.id.nameitem)
    var desc = itemView.findViewById<TextView>(R.id.descriptionitem)
    var price = itemView.findViewById<TextView>(R.id.priceitem)
  /*  init {
        itemView.setOnClickListener(View.OnClickListener { val intent=Intent() })
    }*/
    fun bind(data:RecyclerModel, onClick:(position:Int)-> Unit) {
        name.text=data.name
        desc.text=data.descript
        price.text=data.price

        itemView.setOnClickListener{
            Log.d("position","in recviewAdapter : $adapterPosition")
            onClick(adapterPosition)
        }
    }

}
