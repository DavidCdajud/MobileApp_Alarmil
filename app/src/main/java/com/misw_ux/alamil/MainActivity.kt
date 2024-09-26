package com.misw_ux.alamil

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.show()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            // Crear el popup de confirmación
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Autenticación exitosa")
            builder.setMessage("¿Desea continuar?")

            // Si se presiona "Sí", mostrar SplashActivity y luego redirigir a HomeActivity
            builder.setPositiveButton("Sí") { _, _ ->
                val splashIntent = Intent(this, SplashActivity::class.java)
                splashIntent.putExtra("next_activity", HomeActivity::class.java.name)  // Pasamos el nombre de la actividad
                startActivity(splashIntent)
            }

            // Botón "No"
            builder.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }

            // Mostrar el diálogo
            builder.show()
        }
    }
}
