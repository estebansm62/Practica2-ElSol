package com.example.practica2_elsol_ignat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var adaptador: SolAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val items = ArrayList<Sol>()
        items.add(Sol(R.drawable.corona_solar, "Corona solar"))
        items.add(Sol(R.drawable.erupcionsolar, "Erupcion solar"))
        items.add(Sol(R.drawable.espiculas, "Espiculas"))
        items.add(Sol(R.drawable.filamentos, "Filamentos"))
        items.add(Sol(R.drawable.magnetosfera, "Magnetosfera"))
        items.add(Sol(R.drawable.manchasolar, "Mancha solar"))


        fun selectedOptionMenu(op:Int, itemCard: Int){
            when(op){
                0 ->{
                    items.removeAt(itemCard)
                    adaptador.notifyDataSetChanged()
                    //eliminar
                }
                1 ->{
                    items.add(items[itemCard])
                    adaptador.notifyDataSetChanged()
                    //copiar
                }
            }
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)

        adaptador = SolAdapter(items){selected, indice -> selectedOptionMenu(selected, indice)}
        recyclerView.adapter = adaptador

        val layoutManager = GridLayoutManager(baseContext, 2)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = adaptador
    }

    fun lanzarComparar(){
        val i = Intent(this, CompararActivity::class.java)
        startActivity(i)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id  = item.itemId
        if(id == R.id.action_comparar){
            lanzarComparar()
        }
        return super.onOptionsItemSelected(item)
    }


}