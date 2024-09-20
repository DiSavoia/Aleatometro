package com.example.aleatometro

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.Chronometer
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.min
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val minMinutes = findViewById<EditText>(R.id.minTextNumber)
        val maxMinutes = findViewById<EditText>(R.id.maxTextNumber)
        val mediaPlayer = MediaPlayer.create(this, R.raw.alarm)


        buttonAdd.setOnClickListener {
            if (minMinutes.text.toString() != "" && maxMinutes.text.toString() != "") {
                val minNumber = minMinutes.text.toString().toInt() * 60
                val maxNumber = maxMinutes.text.toString().toInt() * 60
                Toast.makeText(this, "Min: $minNumber, Max: $maxNumber", Toast.LENGTH_SHORT).show()
                val random = Random.nextInt(minNumber, maxNumber)
                Toast.makeText(this, "el numero es: $random", Toast.LENGTH_SHORT).show()
                val timer = object : CountDownTimer((random*1000).toLong(),1000) {

                    override fun onTick(remaining: Long) {
                        Toast.makeText(this@MainActivity, remaining.toString(), Toast.LENGTH_SHORT).show()
                    }

                    override fun onFinish() {
                        Toast.makeText(this@MainActivity,"Terminó!", Toast.LENGTH_SHORT).show()
                        mediaPlayer.start()
                    }
                }
                timer.start()
            }
            else{
                Toast.makeText(this,"Falta completar algún campo!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}