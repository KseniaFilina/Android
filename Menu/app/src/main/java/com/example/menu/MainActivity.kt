package com.example.menu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val textView: TextView = findViewById(R.id.textView)
        when (item.itemId) {
            R.id.action_cat1 -> {
                textView.text = "Вы выбрали кошку"
            }
            R.id.action_cat2 -> {
                textView.text = "Вы выбрали кота"
            }
            R.id.action_cat3 -> {
                textView.text = "Вы выбрали котенка"
            }
        }
        return super.onOptionsItemSelected(item)
    }
}