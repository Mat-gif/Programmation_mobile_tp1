package com.example.application_trains

class Trajets {

     var  horaires = HashMap<Pair<String, String>, List<String>>()

    constructor(){

        // Ajouter des horaires au format 24 heures pour différents trajets
        horaires[Pair("paris", "marseille")] = listOf(
            "08:00", "10:30", "15:15", "12:00", "14:30", "18:00"
        )

        horaires[Pair("paris", "lyon")] = listOf(
            "08:45", "09:45", "13:20", "17:30", "10:15", "15:45"
        )

        horaires[Pair("lyon", "marseille")] = listOf(
            "07:30", "11:45", "16:00", "08:15", "13:45", "17:30"
        )

        horaires[Pair("bordeaux", "toulouse")] = listOf(
            "10:00", "14:30", "19:15", "11:30", "16:00", "20:30"
        )

        horaires[Pair("nice", "marseille")] = listOf(
            "06:15", "12:30", "18:45", "07:00", "13:15", "19:30"
        )
    }






}