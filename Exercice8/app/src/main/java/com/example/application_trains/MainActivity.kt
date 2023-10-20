package com.example.application_trains

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var buttonValider : Button
    lateinit var start : EditText
    lateinit var stop : EditText
    var trajets = Trajets()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonValider = findViewById(R.id.findButton)
        start = findViewById(R.id.startEdit)
        stop = findViewById(R.id.stopEdit)
        buttonValider.setOnClickListener {
            // Je verifie si le trajet existe
            if (trajets.horaires.containsKey(Pair(start.text.toString().lowercase(),stop.text.toString().lowercase()))) {
                var intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("start",start.text.toString().lowercase())
                intent.putExtra("stop",stop.text.toString().lowercase())
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Le trajet n'existe pas",Toast.LENGTH_LONG).show()
            }
        }
    }

}

