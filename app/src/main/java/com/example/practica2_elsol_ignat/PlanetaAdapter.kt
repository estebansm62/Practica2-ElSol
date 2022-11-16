package com.example.practica2_elsol_ignat

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PlanetaAdapter(context: Context, items: List<Planeta>): ArrayAdapter<Planeta>(context, 0, items){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_planeta, parent, false)

        getItem(position)?.let { product ->
            view.findViewById<TextView>(R.id.nombrePlaneta).apply {
                text = product.nombre
            }

        }
        return view
    }
}