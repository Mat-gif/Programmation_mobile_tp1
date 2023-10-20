package com.example.myfirstproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var nom: TextView
    lateinit var prenom: TextView
    lateinit var age: TextView
    lateinit var telephone: TextView
    lateinit var boutonRetour : Button
    lateinit var boutonOk : Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        nom = findViewById(R.id.viewNom)
        prenom = findViewById(R.id.viewPrenom)
        age = findViewById(R.id.viewAge)
        telephone = findViewById(R.id.viewTelephone)
        boutonRetour = findViewById(R.id.retour)
        boutonOk = findViewById(R.id.ok)

         nom.text   = intent.getStringExtra("nom").toString()
         prenom.text  = intent.getStringExtra("prenom").toString()
         age.text = intent.getStringExtra("age").toString()
         telephone.text = intent.getStringExtra("telephone").toString()

         boutonRetour.setOnClickListener {
             var intent = Intent(this@SecondActivity, MainActivity::class.java)
             startActivity(intent)
         }

        boutonOk.setOnClickListener {
            var intent = Intent(this@SecondActivity, ThirdActivity::class.java)
            intent.putExtra("telephone",telephone.text.toString())
            startActivity(intent)
         }



    }
}