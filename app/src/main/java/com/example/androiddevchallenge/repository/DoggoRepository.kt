package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.R

class DoggoRepository {

    private val doggos : List<Doggo> = ArrayList<Doggo>().apply {
        add(Doggo(0, "KK Slider", "Mozart", R.drawable.animalcrossing))
        add(Doggo(1, "Dog Meat", "Apocalypse", R.drawable.dogmeat))
        add(Doggo(2, "Cerberus", "Under World", R.drawable.cerberus))
        add(Doggo(3, "Duck Hunt", "Troll", R.drawable.duckhunt))
    }

    fun getAllDoggos() : List<Doggo> = doggos

    fun getDoggoById(id:Int) : Doggo? = doggos.firstOrNull { d -> d.id == id }

}