package com.example.androiddevchallenge.extensions

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.repository.Doggo

fun Doggo.getGenderDrawableResource(): Int =
    if(this.gender.equals("male", true)) { R.drawable.ic_male_24 } else { R.drawable.ic_female_24 }