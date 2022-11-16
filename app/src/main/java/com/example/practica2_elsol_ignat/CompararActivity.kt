package com.example.practica2_elsol_ignat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.TextView

class CompararActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparar)

        val planeta1 = findViewById<AutoCompleteTextView>(R.id.planeta1)
        planeta1.threshold = 1

        val diametro1 = findViewById<TextView>(R.id.diamPlaneta1)
        val distancia1 = findViewById<TextView>(R.id.distPlaneta1)
        val densidad1 =  findViewById<TextView>(R.id.densPlanetas1)

        val planeta2 = findViewById<AutoCompleteTextView>(R.id.planeta2)
        planeta2.threshold = 1

        val diametro2 = findViewById<TextView>(R.id.diamPlaneta2)
        val distancia2 = findViewById<TextView>(R.id.distPlaneta2)
        val densidad2 =  findViewById<TextView>(R.id.densPlanetas2)


        PlanetaAdapter(this, Planeta.planetas).also { adapter ->
            planeta1.setAdapter(adapter)
            planeta2.setAdapter(adapter)
        }

        planeta1.setOnItemClickListener { parent, _, position, _ ->
            val product = parent.adapter.getItem(position) as Planeta
            diametro1.text = product.diam.toString()
            distancia1.text = product.dist.toString()
            densidad1.text = product.dens.toString()
        }

        planeta2.setOnItemClickListener { parent, _, position, _ ->
            val product = parent.adapter.getItem(position) as Planeta
            diametro2.text = product.diam.toString()
            distancia2.text = product.dist.toString()
            densidad2.text = product.dens.toString()


        }

    }
}