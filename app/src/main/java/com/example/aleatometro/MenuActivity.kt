package com.example.aleatometro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        title = "Aleatometro"
        val minButton = findViewById<Button>(R.id.btn_min)
        val maxButton = findViewById<Button>(R.id.btn_max)

        val maxMinutes = intent.extras?.getString("maxMinutes")
        val minMinutes = intent.extras?.getString("minMinutes")

        minButton.setOnClickListener{
            val intent = Intent(this@MenuActivity, MinActivity::class.java)
            val bundle = Bundle()
            bundle.putString("maxMinutes", maxMinutes)
            bundle.putString("minMinutes", minMinutes)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        maxButton.setOnClickListener{
            val intent = Intent(this@MenuActivity, MaxActivity::class.java)
            val bundle = Bundle()
            bundle.putString("maxMinutes", maxMinutes)
            bundle.putString("minMinutes", minMinutes)
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }
}