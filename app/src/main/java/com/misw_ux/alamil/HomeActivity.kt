package com.misw_ux.alamil

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Habilitar el botón "Atrás" en la barra de la aplicación
        supportActionBar?.show()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Obtén referencia al botón "+" para misiones
        val btnAddMission = findViewById<ImageButton>(R.id.btnAddMission)
        btnAddMission.setOnClickListener {
            val intent = Intent(this, MissionCreationActivity::class.java)
            startActivity(intent)
        }

        // Obtén referencia al botón "+" para alarmas
        val btnAddAlarm = findViewById<ImageButton>(R.id.btnAddAlarm)
        btnAddAlarm.setOnClickListener {
            val intent = Intent(this, AlarmCreationActivity::class.java)
            startActivity(intent)  // Inicia la actividad para crear una nueva alarma
        }

        // Obtén referencia al botón de corazón
        val btnHeart = findViewById<ImageButton>(R.id.btnHeart)
        btnHeart.setOnClickListener {
            val intent = Intent(this, HeartRateActivity::class.java)
            startActivity(intent)
        }
    }
}
