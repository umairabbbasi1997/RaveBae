package com.fictivestudios.ravebae.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.fictivestudios.ravebae.R

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this,ResgistrationActivity::class.java))
            finish()
        }, 3000)
    }


    override fun setMainFrameLayoutID() {

    }
}