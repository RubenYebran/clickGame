@file:Suppress("DEPRECATION")

package com.example.clickgame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.clickgame.databinding.ActivitySegundaActividadBinding


@Suppress("DEPRECATION")
class segundaActividad : AppCompatActivity() {
    private lateinit var binding: ActivitySegundaActividadBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaActividadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("NOMBRE").toString()//Nombre del Jugador.
        val btn = binding.clickBoton
        var contador: Int = 0

        object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timer.text = "Tiempo: " + millisUntilFinished / 1000
            }
            override fun onFinish() {
                val score = binding.score.text.toString()

                Intent(applicationContext, terceraActividad::class.java).also {
                    it.putExtra("SCORE",score)
                    it.putExtra("NOMBRE",nombre)
                    startActivity(it)
                }
            }
        }.start()

        /* val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        var widthPx = displayMetrics.widthPixels.toFloat()
        var heightPx = displayMetrics.heightPixels.toFloat()
        */

        var X: Float
        var Y: Float
        val vector = arrayListOf("TOCAME BB", "VENI PUES", "MAS RAPIDO", "AHQ")
        var texto: String
        texto = vector[(0..3).random()]
        btn.text = texto

        binding.clickBoton.setOnClickListener() {
            contador += 1
            X = (50..650).random().toFloat()
            Y = (0..1700).random().toFloat()
            texto = vector[(0..3).random()]

            binding.score.text = "$contador"
            btn.x = X
            btn.y = Y
            btn.text = texto
        }
    }
}