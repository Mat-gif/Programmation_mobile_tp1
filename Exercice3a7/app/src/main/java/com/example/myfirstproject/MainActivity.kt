package com.example.myfirstproject

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText

import android.widget.Spinner
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var spinner : Spinner
    lateinit var showDialogueMessage : Button
    lateinit var nom : EditText
    lateinit var prenom : EditText
    lateinit var telephone : EditText
    lateinit var age : EditText
    lateinit var domaine : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        spinner = findViewById(R.id.mySpinner)
        showDialogueMessage = findViewById(R.id.valider)
        nom = findViewById(R.id.editNom)
        prenom = findViewById(R.id.editPrenom)
        telephone = findViewById(R.id.editTelephone)
        age = findViewById(R.id.editAge)

        spinner.onItemSelectedListener = this
        var arrayAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.domaines,
            android.R.layout.simple_spinner_item
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter

        showDialogueMessage.setOnClickListener {
            showAlertDialog()
        }
    }

    fun showAlertDialog() {
        var alertDialog = AlertDialog.Builder(this@MainActivity)

        alertDialog.setTitle("Changement")
            .setMessage("Voulez-vous valider les informations ?")
            .setIcon(R.drawable.alerte_dialog)
            .setCancelable(false)
            .setNegativeButton("Non", DialogInterface.OnClickListener { dialogInterface, which ->
                dialogInterface.cancel()
            })
            .setPositiveButton("Oui", DialogInterface.OnClickListener { dialogInterface, which ->

                var intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("nom",nom.text.toString())
                intent.putExtra("prenom",prenom.text.toString())
                intent.putExtra("age",age.text.toString())
                intent.putExtra("telephone",telephone.text.toString())
                intent.putExtra("domaine",domaine)
                startActivity(intent)
            })
        alertDialog.create().show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        domaine = parent!!.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}
