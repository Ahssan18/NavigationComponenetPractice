package com.example.navigationcomponenetpractice

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.navigationcomponenetpractice.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var navcontroller: NavController
    lateinit var binding: ActivityMainBinding
    lateinit var appBar: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navcontroller = navHostFragment.navController
        appBar = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.notificationFragment,
                R.id.settingFragment2
            ), binding.drawerLay
        )
        binding.bottomNav.setupWithNavController(navcontroller)
        binding.drawer.setupWithNavController(navcontroller)
        setupActionBarWithNavController(navcontroller, appBar)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.info -> {
                var action = NavMainDirections.actionGlobalAboutAppFragment()
                navcontroller.navigate(action)
                true
            }
            else -> {
                item.onNavDestinationSelected(navcontroller) || super.onOptionsItemSelected(item)
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navcontroller.navigateUp(appBar) || super.onSupportNavigateUp()
    }
}