package com.example.clickgame

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.clickgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val builder = AlertDialog.Builder(this)
/*
        var score = intent.getStringExtra("SCORE")?.toInt()
        if(score != null){
            loadData()
            saveData()
        }
*/
        binding.btnInicio.setOnClickListener() {
            val nombre = binding.nombreUsuario.text.toString()
            if(nombre != ""){
                Intent(applicationContext, segundaActividad::class.java).also{
                    it.putExtra("NOMBRE",nombre)
                    startActivity(it)
                }
            }else{
                builder.setTitle("Error")
                builder.setMessage("Debes ingresar tu nombre.")
                builder.setNegativeButton("Cerrar Aplicación") { dialogInterface: DialogInterface, i: Int -> finish() }
                builder.setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int -> }
                builder.show()
            }
        }
    }
/*
    private fun saveData() {
        var score = intent.getStringExtra("SCORE")?.toInt()
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        binding.recordString.text = "Record Actual:$score"
        val editor = sharedPreferences.edit()
        editor.apply{
            putString("STRING_KEY",score.toString())
        }.apply()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY", "0")
        binding.recordString.text = savedString
    }
*/
}