package com.misw_ux.alamil

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Obtener la actividad a la que redirigir después del splash
        val nextActivity = intent.getSerializableExtra("next_activity") as Class<*>

        // Espera 1.5 segundos y luego inicia la siguiente actividad
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, nextActivity)
            startActivity(intent)
            finish()  // Cierra la actividad para que no pueda regresar
        }, 1500) // 1.5 segundos
    }
}
