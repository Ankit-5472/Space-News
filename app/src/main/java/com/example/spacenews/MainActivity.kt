package com.example.spacenews

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.spacenews.baseClass.BaseActivity
import com.example.spacenews.databinding.ActivityMainBinding
import com.example.spacenews.fragment.navbar.HomeFragment
import com.example.spacenews.fragment.navbar.MoreFragment
import com.example.spacenews.fragment.navbar.PodcastFragment
import com.example.spacenews.fragment.navbar.SavedFragment
import com.example.spacenews.fragment.navbar.VideoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this);
        binding.bottomNavigationView.setSelectedItemId(R.id.nav_home);
        replaceFragment(HomeFragment())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.flContent, HomeFragment())
                    .commit()
                return true
            }
            R.id.nav_video -> {
                supportFragmentManager.beginTransaction().replace(R.id.flContent, VideoFragment())
                    .commit()
                return true
            }
            R.id.nav_podcasts -> {
                supportFragmentManager.beginTransaction().replace(R.id.flContent, PodcastFragment())
                    .commit()
                return true
            }
            R.id.nav_saved -> {
                supportFragmentManager.beginTransaction().replace(R.id.flContent, SavedFragment())
                    .commit()
                return true
            }
            R.id.nav_more -> {
                supportFragmentManager.beginTransaction().replace(R.id.flContent, MoreFragment())
                    .commit()
                return true
            }

        }
        return true
    }

}