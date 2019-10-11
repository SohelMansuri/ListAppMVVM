package com.sohel.mansuri.listappmvvm.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sohel.mansuri.listappmvvm.R
import com.sohel.mansuri.listappmvvm.models.Hero

class HeroAdapter(
    private val context: Context,
    private val heroes: List<Hero>
) : RecyclerView.Adapter<HeroAdapter.HeroHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): HeroHolder {
        return HeroHolder(LayoutInflater.from(context).inflate(R.layout.hero_item, parent, false))
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.bind(heroes[position])
    }


    inner class HeroHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val id = itemView.findViewById<TextView>(R.id.hero_item_id)
        private val publicIdentity = itemView.findViewById<TextView>(R.id.hero_item_public_identity)
        private val age = itemView.findViewById<TextView>(R.id.hero_item_age)

        fun bind(hero: Hero) {
            id.text = "ID: ${hero.listId}"
            publicIdentity.text = hero.publicIdentity ?: ""
            age.text = hero.age.toString()
        }
    }
}