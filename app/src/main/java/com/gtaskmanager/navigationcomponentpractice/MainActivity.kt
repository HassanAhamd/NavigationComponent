package com.gtaskmanager.navigationcomponentpractice

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigation_View: NavigationView
    private lateinit var listner: NavController.OnDestinationChangedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation_View = findViewById(R.id.navigation_view)
        drawerLayout = findViewById(R.id.drawerLayout)
        navController = findNavController(R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        navigation_View.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

        listner= NavController.OnDestinationChangedListener { controller, destination, arguments ->
        when (destination.id) {
                R.id.firstFragment -> {
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.black)))

                }
                R.id.secondFragment2 -> {
                 supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.blue)))

                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listner)
    }

    override fun onPause() {
        super.onPause()
        navController.addOnDestinationChangedListener(listner)
    }
    override fun onSupportNavigateUp(): Boolean {
         navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}