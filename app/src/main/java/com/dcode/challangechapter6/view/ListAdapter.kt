package com.dcode.challangechapter6.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dcode.challangechapter6.databinding.ListItemBinding
import com.dcode.challangechapter6.model.responseProductItem


class ListAdapter(var listcar : List<responseProductItem>, var mContext: Context): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var onDelete : ((responseProductItem)->Unit)? = null
    var onDetail : ((responseProductItem)->Unit)? = null



    class ViewHolder(var binding : ListItemBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        var view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.nameCar.text = listcar!![position].name
        holder.binding.categoryCar.text = listcar!![position].category
        holder.binding.priceCar.text = listcar!![position].price.toString()
        Glide.with(holder.itemView.context).load(listcar!![position].imageLink).into(holder.binding.imgCar)

        holder.binding.Card.setOnClickListener(){
            var bund = Bundle()
            var move = Intent(mContext, DetailActivity::class.java)
            move.putExtra("name", listcar!![position].name.toString())
            move.putExtra("popularity", listcar!![position].rating.toString())
            move.putExtra("imagelink", listcar!![position].imageLink)
            move.putExtra("desc",listcar!![position].description)
//            move.putExtra("name", "istcar!![position].name.toString()")
            startActivity(mContext, move,bund)
        }

    }

    override fun getItemCount(): Int {

        return listcar.size

    }
}