package com.example.calendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.Calendar
import java.util.Locale

class MainActivity2 : AppCompatActivity() {
    lateinit var retourEventButton : Button
    lateinit var ajouterEventButton : Button
    lateinit var dateEvent : EditText
    lateinit var debut : EditText
    lateinit var fin : EditText
    lateinit var events : HashMap<String, MutableList<MyEvent>>
    lateinit var name : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        retourEventButton = findViewById(R.id.retourEvent)
        ajouterEventButton = findViewById(R.id.validerEvent)
        dateEvent = findViewById(R.id.editDateSeleted)
        name = findViewById(R.id.nomEdit)
        debut = findViewById(R.id.debutH)
        fin = findViewById(R.id.finH)

        // Heure actuelle
        val calendar: Calendar = Calendar.getInstance()
        val currentHour: Int = calendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute: Int = calendar.get(Calendar.MINUTE)
        // Calcul l heure de fin
        var defaultEndHour = currentHour + 1
        // Je verifie que l heure ne depasse pas 23h
        if (defaultEndHour > 23) {
            defaultEndHour = 23
        }
        // Mise en forme de l heure
        val defaultStartTime = String.format(Locale.getDefault(), "%02d:%02d", currentHour, currentMinute)
        val defaultEndTime = String.format(Locale.getDefault(), "%02d:%02d", defaultEndHour, currentMinute)

        // Affichez l heure de debut et l heure de fin par defaut dans les EditText
        debut.setText(defaultStartTime)
        fin.setText(defaultEndTime)

        // Je recupere les donnees provenant de l activite principale
        dateEvent.setText(intent.getStringExtra("date").toString())
        events = intent.getSerializableExtra("events") as HashMap<String, MutableList<MyEvent>>

        // bouton de retour
        retourEventButton.setOnClickListener {
            var intent = Intent(this@MainActivity2, MainActivity::class.java)
            intent.putExtra("events", events)
            startActivity(intent)
        }
        ajouterEventButton.setOnClickListener {
            // je cree mon evenement et je le stock
            var event = MyEvent(name.text.toString(),dateEvent.text.toString(),debut.text.toString(),fin.text.toString() )
            events.computeIfAbsent(dateEvent.text.toString()) { mutableListOf() }.add(event)
            // retour a l activite principale
            var intent = Intent(this@MainActivity2, MainActivity::class.java)
            intent.putExtra("events", events)
            startActivity(intent)
        }
    }
}