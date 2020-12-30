package com.projectapp2.kotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import com.projectapp2.kotlin.R
import com.projectapp2.kotlin.model.Ability
import kotlinx.android.synthetic.main.row_adapte_bis.view.*

class MyAbilityAdapter(private val context: Context, private val movieList: MutableList<Ability>): RecyclerView.Adapter<MyAbilityAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_adapte_bis, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txt_name.text = movieList[position].name
        holder.txt_url.text = movieList[position].url
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_name : TextView
        var txt_url : TextView

        init {
            txt_name = itemView.firstLine
            txt_url = itemView.secondLine
        }
    }
}