package com.example.kisileruygulamasi.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

//Extensions kullanımı
fun Navigation.gecis(it:View, id:Int) {
    findNavController(it).navigate(id)

}
//Overloading kullanımı
fun Navigation.gecis(it:View, id:NavDirections) {
    findNavController(it).navigate(id)

}