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

        // Lee la próxima actividad desde el intent
        val nextActivityClassName = intent.getStringExtra("next_activity")

        // Espera 3 segundos antes de redirigir
        Handler(Looper.getMainLooper()).postDelayed({
            // Intenta iniciar la próxima actividad
            try {
                val nextActivityClass = Class.forName(nextActivityClassName)
                val intent = Intent(this, nextActivityClass)
                startActivity(intent)
                finish()
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            }
        }, 3000) // 3 segundos de espera
    }
}
