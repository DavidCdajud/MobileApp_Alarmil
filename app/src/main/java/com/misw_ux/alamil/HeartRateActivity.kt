package com.misw_ux.alamil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import android.graphics.Color

class HeartRateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heart_rate)

        // Habilitar el botón "Atrás" en la barra de la aplicación
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val lineChart = findViewById<LineChart>(R.id.lineChart)

        // Datos del gráfico (simulación de valores BPM a lo largo del tiempo)
        val values = ArrayList<Entry>()
        values.add(Entry(0f, 60f))    // Tiempo 00:00, BPM 60
        values.add(Entry(6f, 90f))    // Tiempo 06:00, BPM 90
        values.add(Entry(12f, 150f))  // Tiempo 12:00, BPM 150
        values.add(Entry(18f, 120f))  // Tiempo 18:00, BPM 120
        values.add(Entry(24f, 80f))   // Tiempo 24:00, BPM 80

        // Configurar el conjunto de datos
        val lineDataSet = LineDataSet(values, "BPM")
        lineDataSet.color = Color.WHITE
        lineDataSet.valueTextColor = Color.TRANSPARENT // No mostrar valores
        lineDataSet.setDrawCircles(false) // No mostrar círculos en los puntos
        lineDataSet.lineWidth = 2f
        lineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER // Para la curva suave
        lineDataSet.setDrawFilled(true)
        lineDataSet.fillColor = Color.GREEN

        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(lineDataSet)

        val lineData = LineData(dataSets)

        // Configurar el gráfico
        lineChart.data = lineData
        lineChart.description.isEnabled = false  // Sin descripción
        lineChart.setTouchEnabled(false)  // No habilitar interacciones táctiles
        lineChart.setScaleEnabled(false)  // Desactivar zoom
        lineChart.setPinchZoom(false)     // Desactivar zoom con pinch
        lineChart.axisRight.isEnabled = false // Desactivar eje derecho

        // Configurar eje X (Tiempo)
        val xAxis: XAxis = lineChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.textColor = Color.WHITE
        xAxis.axisLineColor = Color.WHITE
        xAxis.labelRotationAngle = 45f
        xAxis.granularity = 1f
        xAxis.valueFormatter = XAxisValueFormatter()

        // Configurar eje Y (BPM)
        val leftAxis: YAxis = lineChart.axisLeft
        leftAxis.textColor = Color.WHITE
        leftAxis.axisLineColor = Color.WHITE
        leftAxis.setDrawGridLines(true)
        leftAxis.gridColor = Color.RED  // Color de las líneas de grid
        leftAxis.axisMinimum = 50f  // Valor mínimo del eje Y
        leftAxis.axisMaximum = 200f  // Valor máximo del eje Y

        lineChart.invalidate() // Refrescar gráfico
    }
}

// Formateador para los valores del eje X (Tiempo)
class XAxisValueFormatter : com.github.mikephil.charting.formatter.ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        return when (value) {
            0f -> "00:00"
            6f -> "06:00"
            12f -> "12:00"
            18f -> "18:00"
            24f -> "24:00"
            else -> ""
        }
    }
}
