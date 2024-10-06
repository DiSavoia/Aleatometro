package com.example.aleatometro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MaxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_max)
        title = "Aleatometro"
        val backButton = findViewById<Button>(R.id.btn_goBack)
        val maxInput = findViewById<EditText>(R.id.etxt_max)

        val minMinutes = intent.extras?.getString("minMinutes").toString()

        var maxMinutes = intent.extras?.getString("maxMinutes").toString()
        if (maxMinutes != "null"){
            maxInput.setText(maxMinutes)
        }

        backButton.setOnClickListener{
            val intent = Intent(this@MaxActivity, MenuActivity::class.java)

            maxMinutes = maxInput.text.toString()
            val bundle = Bundle()
            bundle.putString("maxMinutes", maxMinutes)
            bundle.putString("minMinutes", minMinutes)
            intent.putExtras(bundle)

            startActivity(intent)
        }

    }
}