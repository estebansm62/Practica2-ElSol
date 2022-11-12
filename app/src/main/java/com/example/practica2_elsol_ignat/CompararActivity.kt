package com.example.practica2_elsol_ignat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView

class CompararActivity : AppCompatActivity() {
    private lateinit var nameTextField2: AutoCompleteTextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparar)

        val nameTextField1 = findViewById<AutoCompleteTextView>(R.id.planeta1)

        val diametro1 = findViewById<TextView>(R.id.diamPlaneta1)
        val distancia1 = findViewById<TextView>(R.id.distPlaneta1)
        val densidad1 =  findViewById<TextView>(R.id.densPlanetas1)

        val nameTextField2 = findViewById<AutoCompleteTextView>(R.id.planeta2)

        val diametro2 = findViewById<TextView>(R.id.diamPlaneta2)
        val distancia2 = findViewById<TextView>(R.id.distPlaneta2)
        val densidad2 =  findViewById<TextView>(R.id.densPlanetas2)




        PlanetaAdapter(this, Planeta.planetas).also { adapter ->
            nameTextField1.setAdapter(adapter)
            nameTextField2.setAdapter(adapter)
        }

        nameTextField1.setOnItemClickListener { parent, _, position, _ ->
            val product = parent.adapter.getItem(position) as Planeta
            diametro1.text = product.diam.toString()
            distancia1.text = product.dist.toString()
            densidad1.text = product.dens.toString()
        }

        nameTextField2.setOnItemClickListener { parent, _, position, _ ->
            val product = parent.adapter.getItem(position) as Planeta
            diametro2.text = product.diam.toString()
            distancia2.text = product.dist.toString()
            densidad2.text = product.dens.toString()


        }

    }
}