package com.fictivestudios.ravebae.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.fictivestudios.ravebae.R

class ResgistrationActivity : AppCompatActivity() {

    lateinit var navControllerReg : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeration)

        getRegActivity = this

        navControllerReg = Navigation.findNavController(this, R.id.container_reg);

        navControllerReg.navigate(R.id.preLoginFragment)
    }
    companion object{
        var getRegActivity: ResgistrationActivity? =null
    }
}