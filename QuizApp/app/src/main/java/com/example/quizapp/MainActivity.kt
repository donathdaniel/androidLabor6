package com.example.quizapp

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.example.quizapp.ui.fragments.Home
import com.example.quizapp.ui.fragments.QuestionList
import com.example.quizapp.ui.fragments.StartQuiz
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //navigation drawer
        /*val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        findViewById<MaterialToolbar>(R.id.topAppBar).setNavigationOnClickListener {
            drawerLayout.open()
        }*/

        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        /*navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true
            drawerLayout.close()
            true
        }*/

        //navigation
        navigationView.setNavigationItemSelectedListener{ menuItem ->
            when (menuItem.itemId) {
                R.id.navigationItem_home -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragment_container, StartQuiz())
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                    return@setNavigationItemSelectedListener true
                }
                R.id.navigationItem_quizTime -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragment_container, StartQuiz())
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                    return@setNavigationItemSelectedListener true
                }
                R.id.navigationItem_profile -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragment_container, StartQuiz())
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                    return@setNavigationItemSelectedListener true
                }
                R.id.navigationItem_listOfQuestions -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragment_container, QuestionList())
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                    return@setNavigationItemSelectedListener true
                }
                R.id.navigationItem_newQuestion -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragment_container, StartQuiz())
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                    return@setNavigationItemSelectedListener true
                }
                else -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragment_container, Home())
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                    return@setNavigationItemSelectedListener true
                }
            }
        }
    }

}