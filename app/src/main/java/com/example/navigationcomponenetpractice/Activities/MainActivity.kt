package com.example.navigationcomponenetpractice.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.navigationcomponenetpractice.R
import com.example.navigationcomponenetpractice.databinding.ActivityMainBinding
import com.example.navigationcomponenetpractice.setupWithNavController

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
     var navcontroller: LiveData<NavController>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       setUpNavigation()

    }

    private fun setUpNavigation() {
        var navgraph_ids=listOf(R.navigation.nav_home,R.navigation.nav_setting,R.navigation.nav_notification)
        var controller=binding.nav.setupWithNavController(navgraph_ids,supportFragmentManager,R.id.fragment,intent)
        controller.observe(this){
            setupActionBarWithNavController(it)
        }
        navcontroller=controller

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setUpNavigation()
    }
    override fun onSupportNavigateUp(): Boolean {
        return navcontroller?.value?.navigateUp()!! || super.onNavigateUp()
    }

}