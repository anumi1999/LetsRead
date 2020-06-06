package com.internshala.letsread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView : NavigationView

    var previousMenuItem: MenuItem ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawLayout)
        coordinatorLayout= findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.navigationView)
        setUpToolBar()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, Document_Fragment())
            .addToBackStack("Dashboard")
            .commit()
        supportActionBar?.title = "Dashboard"
        navigationView.setCheckedItem(R.id.Dashboard)

        val actionBarDrawerToggle = ActionBarDrawerToggle(this@MainActivity ,
            drawerLayout , R.string.open_drawer , R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            if(previousMenuItem!=null){
                previousMenuItem?.isChecked = false
            }

            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

            when(it.itemId){
                R.id.Dashboard -> {
                   supportFragmentManager.beginTransaction()
                       .replace(R.id.frame, Document_Fragment())
                       .commit()
                    supportActionBar?.title = "Dashboard"
                    drawerLayout.closeDrawers()
                }
                R.id.Favorites -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, FavoritesFragments())
                        .commit()
                    supportActionBar?.title = "Favorites"
                    drawerLayout.closeDrawers()
                }
                R.id.Profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, ProfileFragment())
                        .commit()
                    supportActionBar?.title = "Profile"
                    drawerLayout.closeDrawers()
                }
                R.id.AA -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, AboutAppFragment())
                        .commit()
                    supportActionBar?.title = "About Application"
                    drawerLayout.closeDrawers()
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }
    fun setUpToolBar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title ="ToolBar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)
        when(frag){
            !is Document_Fragment -> { supportFragmentManager.beginTransaction()
                .replace(R.id.frame, Document_Fragment())
                .commit()
                supportActionBar?.title = "Dashboard"}
                else -> super.onBackPressed()
        }
        super.onBackPressed()
    }
}
