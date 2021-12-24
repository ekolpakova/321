package com.example.worldcinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.worldcinema.fragments.CollectionFragment
import com.example.worldcinema.fragments.CompilationFragment
import com.example.worldcinema.fragments.HomeFragment
import com.example.worldcinema.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val compilationFragment = CompilationFragment()
        val collectionFragment = CollectionFragment()
        val profileFragment = ProfileFragment()
        val bottom_navigation : BottomNavigationView
        bottom_navigation = findViewById(R.id.bottom_navigation)

       makeCurrentFragment(homeFragment)
       bottom_navigation.setOnItemSelectedListener {
           when(it.itemId) {
               R.id.icon__home -> makeCurrentFragment(homeFragment)
               R.id.icon__compilation -> makeCurrentFragment(compilationFragment)
               R.id.icon__collection -> makeCurrentFragment(collectionFragment)
               R.id.icon__profile -> makeCurrentFragment(profileFragment)
           }
           true
       }

   }

   private fun makeCurrentFragment(fragment: Fragment) =
       supportFragmentManager.beginTransaction().apply {
           replace(R.id.fl_wrapper, fragment)
           commit()
       }
}
