package com.example.practica2_elsol_ignat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class SolAdapter (var items: ArrayList<Sol>,val selectedOptionMenu:(Int, Int)-> Unit) : RecyclerView.Adapter<SolAdapter.SolViewHolder>(){

    class SolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imagenAdapter = itemView.findViewById<ImageView>(R.id.imagenItem)
        var textoAdapter = itemView.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SolViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_sol, viewGroup, false)
        return SolViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SolViewHolder, position: Int) {
        val item = items[position]
        holder.imagenAdapter.setImageResource(item.imagen)
        holder.imagenAdapter.scaleType = ImageView.ScaleType.FIT_XY
        holder.textoAdapter.title = item.texto

        holder.textoAdapter.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.action_copiar -> selectedOptionMenu(1,position)
                R.id.action_eliminar -> selectedOptionMenu(0,position)
            }
            return@setOnMenuItemClickListener true
        }

    }

    override fun getItemCount(): Int {
        return  items.size
    }
}