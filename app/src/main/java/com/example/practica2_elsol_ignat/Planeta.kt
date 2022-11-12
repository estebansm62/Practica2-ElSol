package com.example.practica2_elsol_ignat


data class Planeta(val nombre: String, val diam: Double, val dist: Double, val dens: Int) {

    companion object {
        val planetas = listOf(
            Planeta("Mercurio",0.382 ,0.387 ,5400),
            Planeta("Venus",0.949 ,0.723 ,5250),
            Planeta("Tierra",1.0 ,1.0 ,5520),
            Planeta("Marte",0.53 ,1.542 ,3960),
            Planeta("Jupiter", 11.2 ,5.203 ,1350 ),
            Planeta("Saturno",9.41 ,9.539 ,700 ),
            Planeta("Urano", 3.38 ,19.81 ,1200 ),
            Planeta("Neptuno",3.81 ,30.07 ,1500),
            Planeta("Pluton",0.0 ,39.44 ,5),
            )
    }

    override fun toString(): String {
        return nombre
    }
}

