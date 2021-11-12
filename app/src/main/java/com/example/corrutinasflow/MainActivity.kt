package com.example.corrutinasflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.corrutinasflow.ui.view.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = this.supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.container, HomeFragment.newInstance())
        transaction.commit()


    }
}