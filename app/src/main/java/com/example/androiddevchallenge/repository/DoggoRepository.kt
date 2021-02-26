package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.R

class DoggoRepository {

    private val doggos : List<Doggo> = ArrayList<Doggo>().apply {
        add(Doggo(0, "KK Slider", "Mozart Boi", R.drawable.animalcrossing))
        add(Doggo(1, "Dog Meat", "Apocalypse Boi", R.drawable.dogmeat))
        add(Doggo(2, "Cerberus", "Inferno Boi", R.drawable.cerberus))
        add(Doggo(3, "Duck Hunt", "Troll Boi", R.drawable.duckhunt))
        add(Doggo(4, "D-Dog", "Punished Boi", R.drawable.metalgear))
        add(Doggo(5, "Caesar", "Good Boi", R.drawable.wargroove))
        add(Doggo(6, "Sif", "Sword Boi", R.drawable.darksouls))
    }

    fun getAllDoggos() : List<Doggo> = doggos

    fun getDoggoById(id:Int) : Doggo? = doggos.firstOrNull { d -> d.id == id }

}