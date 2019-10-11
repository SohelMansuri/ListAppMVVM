package com.sohel.mansuri.listappmvvm.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.sohel.mansuri.listappmvvm.models.Hero
import com.sohel.mansuri.listappmvvm.respositories.HeroRepository

class MainActivityViewModel : ViewModel() {
    private var heroes: MutableLiveData<List<Hero>> = MutableLiveData()

    fun init() {
        heroes = HeroRepository.getHeroes()
    }

    fun getHeroes(): LiveData<List<Hero>> {
        return heroes
    }
}