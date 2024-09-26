package com.misw_ux.alamil

import android.app.AlertDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class AlarmCreationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_alarm)

        supportActionBar?.show()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Elementos de la interfaz
        val btnCreateAlarm = findViewById<Button>(R.id.btnCreateAlarm)
        val btnPickTime = findViewById<ImageButton>(R.id.btnPickTime)
        val tvHora = findViewById<TextView>(R.id.tvHora)

        // Configuración del selector de hora (Time Picker)
        btnPickTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                val selectedTime = "$selectedHour:$selectedMinute:00"
                tvHora.text = selectedTime
            }, hour, minute, true)

            timePickerDialog.show()
        }

        // Botón para crear la alarma
        btnCreateAlarm.setOnClickListener {
            // Crear el popup de confirmación
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmación de Creación")
            builder.setMessage("¿Está seguro de que desea crear la alarma?")

            // Si el usuario confirma, mostrar el popup de éxito
            builder.setPositiveButton("Sí") { _, _ ->
                showSuccessDialog()
            }

            // Si el usuario cancela la acción
            builder.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }

            // Mostrar el diálogo de confirmación
            builder.show()
        }
    }

    // Función para mostrar el popup de éxito
    private fun showSuccessDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alarma Creada")
        builder.setMessage("La alarma ha sido creada correctamente")

        // Al presionar OK, redirigir a la pantalla Home
        builder.setPositiveButton("OK") { _, _ ->
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Cierra la actividad actual para no regresar a ella
        }

        // Mostrar el diálogo de éxito
        builder.show()
    }
}
