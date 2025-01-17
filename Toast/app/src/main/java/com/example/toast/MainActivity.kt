package com.example.toast

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val inflater = layoutInflater
            val container = findViewById<ViewGroup>(R.id.custom_toast_container)
            val layout: View = inflater.inflate(R.layout.custom_toast, container)
            val text: TextView = layout.findViewById(R.id.text)
            text.text = "Пора кормить кота!"
            with (Toast(applicationContext)) {
                setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }
    }
}