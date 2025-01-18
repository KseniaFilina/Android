package com.example.popupmenu

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button)
        val textView : TextView = findViewById(R.id.textView)
        val imageView : ImageView = findViewById(R.id.imageView)

        /*val viewClickListener = View.OnClickListener { view -> showPopupMenu(view) }
        button.setOnClickListener(viewClickListener)
        textView.setOnClickListener(viewClickListener)
        imageView.setOnClickListener(viewClickListener)*/

        val popupMenu = PopupMenu(this, button)
        popupMenu.inflate(R.menu.popup_menu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.red -> {
                    textView.background = ColorDrawable(Color.RED)
                    textView.text = "Вы выбрали красный цвет"
                }
                R.id.yellow -> {
                    textView.background = ColorDrawable(Color.YELLOW)
                    textView.text = "Вы выбрали красный цвет"
                }
                R.id.green -> {
                    textView.background = ColorDrawable(Color.GREEN)
                    textView.text = "Вы выбрали красный цвет"
                }
            }
            false
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            popupMenu.setForceShowIcon(true)
        }

        button.setOnClickListener {
            popupMenu.show()
        }
    }

    /*private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.popupmenu)
        popupMenu.setOnMenuItemClickListener {
            item: MenuItem -> when (item.itemId) {R.id.menu1 ->
        {
            Toast.makeText(applicationContext, "Вы выбрали popupMenu 1", Toast.LENGTH_SHORT).show()
            true
        }
            R.id.menu2 -> {
                Toast.makeText(applicationContext, "Вы выбрали popupMenu 2", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu3 -> {
                Toast.makeText(applicationContext, "Вы выбрали popupMenu 3", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
            }
        }
        popupMenu.setOnDismissListener{
            Toast.makeText(applicationContext, "onDismiss", Toast.LENGTH_SHORT).show()
        }
        popupMenu.show()
    }*/

}