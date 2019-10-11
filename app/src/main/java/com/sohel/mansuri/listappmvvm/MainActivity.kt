package com.sohel.mansuri.listappmvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.sohel.mansuri.listappmvvm.adapters.HeroAdapter
import com.sohel.mansuri.listappmvvm.models.Hero
import com.sohel.mansuri.listappmvvm.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.init()
        mainActivityViewModel.getHeroes().observe(this, Observer<List<Hero>> {
            adapter.notifyDataSetChanged()
        })

        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = HeroAdapter(this, mainActivityViewModel.getHeroes().value ?: listOf())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
