package com.example.thecheezery_245244

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        var btnCold: Button = findViewById(R.id.button_cold_drinks) as Button
        var btnHot: Button = findViewById(R.id.button_hot_drinks) as Button
        var btnSweets: Button = findViewById(R.id.button_sweets) as Button
        var btnSalties: Button = findViewById(R.id.button_salties) as Button

        var intent: Intent = Intent(this, ProductosActivity::class.java)

        btnCold.setOnClickListener {
            // Se envia un parametro utilizando el putExtra, en este caso, el drink es de tipo Cold Drink
            intent.putExtra("product", "cold")
            startActivity(intent)
        }

        btnHot.setOnClickListener {
            // Se envia un parametro utilizando el putExtra, en este caso, el drink es de tipo Cold Drink
            intent.putExtra("product", "hot")
            startActivity(intent)
        }

        btnSweets.setOnClickListener {
            // Se envia un parametro utilizando el putExtra, en este caso, el drink es de tipo Cold Drink
            intent.putExtra("product", "sweet")
            startActivity(intent)
        }

        btnSalties.setOnClickListener {
            // Se envia un parametro utilizando el putExtra, en este caso, el drink es de tipo Cold Drink
            intent.putExtra("product", "saltie")
            startActivity(intent)
        }
    }
}