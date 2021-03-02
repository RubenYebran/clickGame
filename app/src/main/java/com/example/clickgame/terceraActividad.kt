package com.example.clickgame

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clickgame.databinding.ActivityTerceraActividadBinding

class terceraActividad : AppCompatActivity() {
    private lateinit var binding: ActivityTerceraActividadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerceraActividadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getStringExtra("SCORE")?.toInt() //Puntaje del jugador.
        val nombre = intent.getStringExtra("NOMBRE").toString()//Nombre del jugador.

        binding.score.text = score.toString()

        val btn = binding.btn
        btn.setOnClickListener() {
            val mainActivity = Intent(applicationContext, MainActivity::class.java)
            startActivity(mainActivity)
        }
        loadData()
        saveData()
        loadData()
    }
    private fun saveData() {
        val nombre = intent.getStringExtra("NOMBRE").toString()
        val score = intent.getStringExtra("SCORE")?.toInt()
        val recordActual = binding.record.text.toString().toInt()
        if(binding.record.text == "0" || recordActual < score!!){
            binding.record.text = score.toString()
            binding.nombreUsuario.text = nombre
        }
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putString("STRING_KEY",binding.record.text.toString())
            putString("STRING_KEY2",binding.nombreUsuario.text.toString())//Nombre
        }.apply()
    }

    private fun loadData() {
        val nombre = intent.getStringExtra("NOMBRE").toString()
        val score = intent.getStringExtra("SCORE")?.toInt()
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY","0")
        val savedString2 = sharedPreferences.getString("STRING_KEY2","")

        if(savedString == "null"){
            binding.nombreUsuario.text = nombre
            binding.record.text = score.toString()
        }else{
            binding.nombreUsuario.text = savedString2
            binding.record.text = savedString
        }

    }

}