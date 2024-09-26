package com.misw_ux.alamil

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MissionCreationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mission_creation)

        supportActionBar?.show()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvFechaInicio = findViewById<TextView>(R.id.tvFechaInicio)
        val btnFechaInicio = findViewById<ImageButton>(R.id.btnFechaInicio)

        val tvHoraInicio = findViewById<TextView>(R.id.tvHoraInicio)
        val btnHoraInicio = findViewById<ImageButton>(R.id.btnHoraInicio)

        val tvFechaFin = findViewById<TextView>(R.id.tvFechaFin)
        val btnFechaFin = findViewById<ImageButton>(R.id.btnFechaFin)

        val tvHoraFin = findViewById<TextView>(R.id.tvHoraFin)
        val btnHoraFin = findViewById<ImageButton>(R.id.btnHoraFin)

        val btnCrearMision = findViewById<Button>(R.id.btnCrearMision)

        // Selector de Fecha Inicio
        btnFechaInicio.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                tvFechaInicio.text = selectedDate
            }, year, month, day)
            datePickerDialog.show()
        }

        // Selector de Hora Inicio
        btnHoraInicio.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                val selectedTime = "$selectedHour:$selectedMinute:00"
                tvHoraInicio.text = selectedTime
            }, hour, minute, true)
            timePickerDialog.show()
        }

        // Selector de Fecha Fin
        btnFechaFin.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                tvFechaFin.text = selectedDate
            }, year, month, day)
            datePickerDialog.show()
        }

        // Selector de Hora Fin
        btnHoraFin.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                val selectedTime = "$selectedHour:$selectedMinute:00"
                tvHoraFin.text = selectedTime
            }, hour, minute, true)
            timePickerDialog.show()
        }

        // Mostrar popup de confirmación y volver a la pantalla HomeActivity
        btnCrearMision.setOnClickListener {
            // Crear el AlertDialog de confirmación
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Misión creada")
            builder.setMessage("La misión se ha creado exitosamente")

            // Acción al hacer clic en "OK"
            builder.setPositiveButton("OK") { _, _ ->
                // Redirigir a HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()  // Terminar la actividad actual para que no vuelva aquí al presionar "atrás"
            }

            // Mostrar el diálogo
            builder.show()
        }
    }
}
