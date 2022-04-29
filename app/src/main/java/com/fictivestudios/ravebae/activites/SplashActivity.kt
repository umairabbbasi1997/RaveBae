package com.fictivestudios.ravebae.activites

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //setContentView(R.layout.activity_splash)

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        // Keep the splash screen visible for this Activity
        splashScreen.setKeepOnScreenCondition { true }
        startActivity(Intent(this, ResgistrationActivity::class.java))
        finish()

    }
}