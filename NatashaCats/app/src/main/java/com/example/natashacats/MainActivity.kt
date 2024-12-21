package com.example.natashacats

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val text2 : TextView = findViewById(R.id.textView2)
        val text3 : TextView = findViewById(R.id.textView3)
        val text4 : TextView = findViewById(R.id.textView4)
        val bottomImage : ImageView = findViewById(R.id.cat_4)

        bottomImage.setOnClickListener {
            val phrases = listOf(
                "Уже 6 часов утра, Наташ",
                "Вставай, мы там все уронили",
                "Мы уронили вообще все, Наташ, честно",
                "Наташ, ты че опять лежишь?",
                "Часики-то тикают",
                "Мужика хоть нашла себе?",
                "Уже деточек пора рожать вообще-то")
            val shuffledList = phrases.shuffled()

            text2.text = shuffledList[0]
            text3.text = shuffledList[1]
            text4.text = shuffledList[2]
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}