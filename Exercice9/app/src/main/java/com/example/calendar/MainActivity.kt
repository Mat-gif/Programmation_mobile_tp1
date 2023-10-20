package com.example.calendar

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.shuhart.materialcalendarview.MaterialCalendarView
import com.shuhart.materialcalendarview.OnDateSelectedListener
import java.text.SimpleDateFormat
import java.util.Calendar
import androidx.core.view.get
import com.shuhart.materialcalendarview.CalendarDay


class MainActivity : AppCompatActivity() {

    lateinit var calendarView : MaterialCalendarView
    lateinit var today : Button
    lateinit var add : Button
    lateinit var events : HashMap<String, MutableList<MyEvent>>
    var dateFormat = SimpleDateFormat("MM/dd/yyyy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // si c est la première fois j initialise la ma Hasmap comme vide
        // sinon je recupère l evenements via le intent
        if (intent.hasExtra("events")) {
            events = intent.getSerializableExtra("events") as HashMap<String, MutableList<MyEvent>>
        } else {
            events = HashMap()
        }

        calendarView = findViewById(R.id.calendarView)
        today = findViewById(R.id.today)
        add = findViewById(R.id.add)
        // j initialise la calendrier a la date d aujoudhui
        val currentDate = Calendar.getInstance()
        calendarView.setSelectedDate(currentDate.time)

        // je creer un listener d evenment
        val dateSelectedListener = object : OnDateSelectedListener {
            override fun onDateSelected(widget: MaterialCalendarView, date: CalendarDay, selected: Boolean) {
                if (selected) {
                    // si je click sur  une date et si elle contient un evenement
                    if(events.containsKey(dateFormat.format(date.date))){
                        // jouvre une fenetre de dialogue
                        var alertDialog = AlertDialog.Builder(this@MainActivity)
                        var info : String = ""
                        for (even in events[dateFormat.format(date.date)]!!){
                            info = info + " - " + even.debut+" : "+even.fin+ " -> " +even.nomEvent + "\n"
                        }
                        // jaffiche les evenements present  ce jour ci
                        alertDialog.setTitle("Evenements prévu :")
                            .setMessage( info)
                            .setCancelable(false)
                            .setNegativeButton("retour", DialogInterface.OnClickListener { dialogInterface, which ->
                                dialogInterface.cancel()
                            })
                        alertDialog.create().show()
                    }
                }
            }
        }
        // je lie le listener au calendrier
        calendarView.addOnDateChangedListener(dateSelectedListener)
        // je definit le bouton pour revenir a aujourdhui
        today.setOnClickListener {
            val currentDate = Calendar.getInstance()
            calendarView.setSelectedDate(currentDate.time)
        }
        // je definit le bouton pour crrer la nouvelle activite
        // cest lactivite 2 qui se charge de renseigner les informations
        add.setOnClickListener {
            var intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("date",dateFormat.format(calendarView.selectedDate?.date))
            intent.putExtra("events", events)
            startActivity(intent)
        }
    }
}
