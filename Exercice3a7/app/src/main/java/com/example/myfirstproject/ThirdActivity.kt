package com.example.myfirstproject

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat

class ThirdActivity : AppCompatActivity() {

    lateinit var telephone: TextView
    lateinit var boutonAppeler : Button
    private val REQUEST_CALL_PERMISSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        telephone = findViewById(R.id.telephoneThird)
        boutonAppeler = findViewById(R.id.appeler)
        telephone.text = intent.getStringExtra("telephone").toString()
        var num = telephone.text

        boutonAppeler.setOnClickListener {

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                // La permission est accordée, lancez l'appel.
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:$num")
                startActivity(intent)
            } else {
            // La permission n'est pas accordée, demandez-la à l'utilisateur.
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CALL_PHONE),
                REQUEST_CALL_PERMISSION
            )
        }
        }


    }


}