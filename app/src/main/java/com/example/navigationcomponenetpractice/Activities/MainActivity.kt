package com.example.navigationcomponenetpractice.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.navigationcomponenetpractice.R

class MainActivity : AppCompatActivity() {
    lateinit var navcontroller: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navcontroller = navHostFragment.navController
        setupActionBarWithNavController(navcontroller)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navcontroller.navigateUp() || super.onNavigateUp()
    }

}