package com.example.mockyfourparameters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.mockyfourparameters.network.Character

class MainAdapter (private val charactersList: List<Character>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    inner class MainViewHolder(private val itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindData(character: Character){
            val title = itemView.findViewById<TextView>(R.id.titleID)
            val publishDate = itemView.findViewById<TextView>(R.id.publishDateID)
            val description = itemView.findViewById<TextView>(R.id.description)
            val image = itemView.findViewById<ImageView>(R.id.cover)

            title.text = character.titleKA
            publishDate.text = character.publish_date
            description.text = character.descriptionKA
            image.load(character.cover){
                transformations(CircleCropTransformation())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindData(charactersList[position])
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}