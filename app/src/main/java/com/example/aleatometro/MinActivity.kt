package com.example.aleatometro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_min)
        title = "Aleatometro"
        val backButton = findViewById<Button>(R.id.btn_goBack)
        val minInput = findViewById<EditText>(R.id.etxt_min)

        val maxMinutes = intent.extras?.getString("maxMinutes").toString()

        var minMinutes = intent.extras?.getString("minMinutes").toString()
        if (minMinutes != "null"){
            minInput.setText(minMinutes)
        }

        backButton.setOnClickListener{
            val intent = Intent(this@MinActivity, MenuActivity::class.java)

            minMinutes = minInput.text.toString()
            val bundle = Bundle()
            bundle.putString("minMinutes", minMinutes)
            bundle.putString("maxMinutes", maxMinutes)
            intent.putExtras(bundle)

            startActivity(intent)
        }

    }
}