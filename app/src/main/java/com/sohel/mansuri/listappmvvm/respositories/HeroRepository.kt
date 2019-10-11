package com.sohel.mansuri.listappmvvm.respositories

import android.arch.lifecycle.MutableLiveData
import com.sohel.mansuri.listappmvvm.models.Hero

object HeroRepository {
    private var heroes = arrayListOf<Hero>()
    fun getHeroes(): MutableLiveData<List<Hero>> {
        setHeroes()

        val data = MutableLiveData<List<Hero>>()
        data.value = heroes
        return data
    }

    private fun setHeroes() {
        val tempHeroes = arrayListOf<Hero>()
        tempHeroes.add(Hero(1, "Ironman", 32))
        tempHeroes.add(Hero(1, "Spiderman", 21))
        tempHeroes.add(Hero(1, "Batman", 28))
        tempHeroes.add(Hero(1, "Superman", 40))
        tempHeroes.add(Hero(1, "Wonder Woman", 26))
        tempHeroes.add(Hero(2, "Daredevil", 27))
        tempHeroes.add(Hero(3, "Thor", 33))
        tempHeroes.add(Hero(3, "Captain America", 112))
        tempHeroes.add(Hero(4, "Hulk", 29))
        tempHeroes.add(Hero(5, "", 29))
        tempHeroes.add(Hero(5, null, 29))

        heroes = ArrayList(tempHeroes.filter { hero -> !hero.publicIdentity.isNullOrEmpty() }
            .sortedWith(compareBy({ it.listId }, { it.publicIdentity })))
    }
}