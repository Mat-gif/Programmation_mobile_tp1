package com.example.application_trains

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TrajetsAdapter(
    var horaires: List<String>,
    var start: String,
    var stop: String,
    var context: Context       // Contexte de l'application Android
) : RecyclerView.Adapter<TrajetsAdapter.TrajetViewHolder>() {

    // Classe interne TrajetViewHolder pour maintenir les éléments de la vue
    class TrajetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Éléments de la vue à afficher
        var textViewStart: TextView = itemView.findViewById(R.id.startDetail) // Affiche la station de départ
        var textViewStop: TextView = itemView.findViewById(R.id.stopDetail)   // Affiche la station d'arrêt
        var textViewHoraire: TextView = itemView.findViewById(R.id.horaireDetail) // Affiche l'horaire

    }

    // Méthode appelée lorsqu'une nouvelle vue est créée
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrajetViewHolder {

        // Créer la mise en page de la carte (card_design.xml)
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_design, parent, false)

        // Créer et retourner un TrajetViewHolder pour cette vue
        return TrajetViewHolder(view)
    }

    // Méthode pour remplir les données dans la vue (appelée pour chaque élément de la liste)
    override fun onBindViewHolder(holder: TrajetViewHolder, position: Int) {
        // Remplir les éléments de la vue avec les données appropriées
        holder.textViewStart.text = start // Affiche la station de départ commune
        holder.textViewStop.text = stop   // Affiche la station d'arrêt commune
        holder.textViewHoraire.text = horaires[position] // Affiche l'horaire correspondant à la position actuelle
    }

    // Méthode pour obtenir le nombre total d'éléments à afficher dans la liste
    override fun getItemCount(): Int {
        return horaires.size // Retourne le nombre d'horaires à afficher
    }
}
