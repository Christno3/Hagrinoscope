package com.dicoding.hagrinoscope

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dicoding.hagrinoscope.camera.Camera_Fragment
import com.dicoding.hagrinoscope.chat.Chat_Fragment
import com.dicoding.hagrinoscope.databinding.ActivityMainBinding
import com.dicoding.hagrinoscope.history.History_Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(Chat_Fragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_camera -> {
                    replaceFragment(Camera_Fragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_history -> {
                    replaceFragment(History_Fragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // Tampilkan default fragment (misalnya, ChatFragment) saat aplikasi pertama kali dibuka
        if (savedInstanceState == null) {
            replaceFragment(Chat_Fragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
