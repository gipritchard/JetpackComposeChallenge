package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.R

class DoggoRepository {

    private val doggos : List<Doggo> = ArrayList<Doggo>().apply {
        add(Doggo(0, "KK Slider", "Mozart Boi", R.drawable.animalcrossing, "Male", "2 years 0 months"))
        add(Doggo(1, "Dog Meat", "Apocalypse Boi", R.drawable.dogmeat, "Male", "4 years 4 months"))
        add(Doggo(2, "Cerberus", "Inferno Boi", R.drawable.cerberus, "Female", "∞ years"))
        add(Doggo(3, "Duck Hunt", "Troll Boi", R.drawable.duckhunt, "Female", "12 years 3 months"))
        add(Doggo(4, "D-Dog", "Punished Boi", R.drawable.metalgear, "Male", "8 months"))
        add(Doggo(5, "Caesar", "Good Boi", R.drawable.wargroove, "Male", "1 year 10 months"))
        add(Doggo(6, "Sif", "Sword Boi", R.drawable.darksouls, "Male", "8 years 7 months"))
    }

    fun getAllDoggos() : List<Doggo> = doggos

    fun getDoggoById(id:Int) : Doggo? = doggos.firstOrNull { d -> d.id == id }

}