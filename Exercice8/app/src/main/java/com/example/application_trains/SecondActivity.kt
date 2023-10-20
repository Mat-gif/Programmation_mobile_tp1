package com.example.application_trains

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    lateinit var retourButton : Button
    lateinit var start : String
    lateinit var stop : String
    lateinit var adapter : TrajetsAdapter
    lateinit var recyclerView: RecyclerView
    var trajets = Trajets()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        recyclerView = findViewById(R.id.recyclerView)
        retourButton = findViewById(R.id.retourButton)

        recyclerView.layoutManager = LinearLayoutManager(this@SecondActivity)

        start  = intent.getStringExtra("start").toString()
        stop  = intent.getStringExtra("stop").toString()



        adapter = TrajetsAdapter(
            ArrayList(trajets.horaires[Pair(start, stop)]).sorted(),
            start,
            stop,
            this@SecondActivity
        )


        recyclerView.adapter =adapter


        retourButton.setOnClickListener {
            var intent = Intent(this@SecondActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}