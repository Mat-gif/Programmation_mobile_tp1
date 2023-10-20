package com.example.tp1_exo2kotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    lateinit var myButton : Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainLayout = findViewById<LinearLayout>(R.id.MainLinearLayout)
        // du padding
        mainLayout.setPadding(50, 50, 50, 50)
        val infos = listOf("Nom : ","Prenom :","Age : ","Domaine : ","Telephone : ")
        // creation des composants graphiques
        for (info in infos ){
            createTextView(mainLayout,info)
            createTextEdit(mainLayout,info)
        }
        createButton(mainLayout , "valider")
    }
    // Creation d'un Boutton
    private fun createButton(mainLayout: LinearLayout, text : String) {
        val button = Button(this)
        // parametre de la layout
        button.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        button.text = text // text a afficher
        mainLayout.addView(button) // ajout layout
    }
    // Creation d'un TextView
    private fun createTextView(mainLayout: LinearLayout, text : String) {
        val textView = TextView(this)
        textView.text = text // text a afficher
        mainLayout.addView(textView) // ajout layout
    }
    // Creation d'un TextEdit
    private fun createTextEdit(mainLayout: LinearLayout, text : String) {
        val textEdit = EditText(this)
        if(text ===  "Age : " || text ===  "Telephone : " ){
            // Pour definir le type de clavier pour la saisie des nombres
            textEdit.inputType = InputType.TYPE_CLASS_NUMBER
        }
        mainLayout.addView(textEdit)
    }
}