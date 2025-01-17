package com.example.whosaidmeow

import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var soundPool : SoundPool
    private lateinit var assetManager : AssetManager

    private var catSound: Int = 0
    private var dogSound: Int = 0
    private var sheepSound: Int = 0
    private var horseSound: Int = 0
    private var frogSound: Int = 0
    private var tigerSound: Int = 0

    private var streamID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val catImage: ImageView = findViewById(R.id.cat)
        val dogImage: ImageView = findViewById(R.id.dog)
        val sheepImage: ImageView = findViewById(R.id.sheep)
        val horseImage: ImageView = findViewById(R.id.horse)
        val frogImage: ImageView = findViewById(R.id.frog)
        val tigerImage: ImageView = findViewById(R.id.tiger)

        val attributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool = SoundPool.Builder()
            .setAudioAttributes(attributes)
            .build()

        assetManager = assets
        catSound = loadSound("sound/catSound.ogg")
        dogSound = loadSound("sound/dogSound.mp3")
        sheepSound = loadSound("sound/sheepSound.mp3")
        horseSound = loadSound("sound/horseSound.mp3")
        frogSound = loadSound("sound/frogSound.mp3")
        tigerSound = loadSound("sound/tigerSound.mp3")

        catImage.setOnClickListener { playSound(catSound) }
        dogImage.setOnClickListener { playSound(dogSound) }
        sheepImage.setOnClickListener { playSound(sheepSound) }
        horseImage.setOnClickListener { playSound(horseSound) }
        frogImage.setOnClickListener { playSound(frogSound) }
        tigerImage.setOnClickListener { playSound(tigerSound) }
    }

    override fun onPause() {
        super.onPause()

        soundPool.release()
    }

    private fun playSound(sound: Int): Int {
        if (sound > 0) {
            streamID = soundPool.play(sound, 1F, 1F, 1, 0, 1F)
        }
        return streamID
    }

    private fun loadSound(fileName: String): Int {
        val afd: AssetFileDescriptor = try {
            application.assets.openFd(fileName)
        } catch (e: IOException) {
            e.printStackTrace()
            Log.d("Meow", "Не могу загрузить файл $fileName")

            return -1
        }
        return soundPool.load(afd, 1)
    }
}