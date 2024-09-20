package com.example.aleatometro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        title = "Aleatometro"
        val minButton = findViewById<Button>(R.id.btn_min)
        val maxButton = findViewById<Button>(R.id.btn_max)

        minButton.setOnClickListener{
            val intent = Intent(this@MenuActivity, MinActivity::class.java)
            startActivity(intent)
        }

    }
}