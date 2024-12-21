package com.example.next

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_next)

        val textview_info : TextView = findViewById(R.id.textView)
        //val user = "Жывотное"
        //val gift = "дырку от бублика"

        val user = intent.getStringExtra("username")
        val gift = intent.extras?.getString("gift")
        textview_info.text = "$user, вам передали $gift"

    }
}