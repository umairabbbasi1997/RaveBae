package com.fictivestudios.ravebae.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.fictivestudios.ravebae.R
import com.fictivestudios.ravebae.fragments.DiscoverFragment
import com.fictivestudios.ravebae.utils.Titlebar
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var navController :NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMainActivity = this

        navController = Navigation.findNavController(this, R.id.container);


       // supportFragmentManager.beginTransaction().add(R.id.container,DiscoverFragment()).commit()


        val navView = bottomBar




        navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item0 -> {
                    // handle click
                    navController.navigate(R.id.activityFragment)

                    true }
                R.id.item1 -> {
                    // handle click

                    navController.navigate(R.id.discoverFragment2)
                    true }
                R.id.item2 -> {
                    // handle click

                    navController.navigate(R.id.messagesFragment)
                    true }

                else -> false
            }
        }

    /*    bottomBar.setActiveItem(1)

        bottomBar.onItemSelected = {

            if (it==0)
            {
                navController.navigate(R.id.activityFragment)
            }
            else if(it==1)
            {
                navController.navigate(R.id.discoverFragment2)
            }
            else if (it==2)
            {
                navController.navigate(R.id.messagesFragment)
            }

        }*/


    }
    fun getFragmentCount(): Int {
        return supportFragmentManager.backStackEntryCount
    }

    override fun onBackPressed() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container)
        val backStackEntryCount = navHostFragment?.childFragmentManager?.backStackEntryCount





        if (backStackEntryCount == 0) {
            Log.d("entry",backStackEntryCount.toString())
            finish()
        } else {
            super.onBackPressed()
        }
    }

    override fun setMainFrameLayoutID() {

    }
    fun getTitlebar(): Titlebar {
        return main_title_bar
    }

    fun hideBottomBar()
    {
        bottomBar.visibility = View.GONE
        btn_home.visibility = View.GONE
    }

    fun showBottomBar()
    {
        bottomBar.visibility = View.VISIBLE
        btn_home.visibility = View.VISIBLE
    }
    companion object{
        var getMainActivity: MainActivity? =null
    }
}