package com.projectapp2.kotlin.activities

import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.projectapp2.kotlin.adapters.MyPokemonAdapter
import com.projectapp2.kotlin.Common.Common
import com.projectapp2.kotlin.Interface.RetrofitService
import com.projectapp2.kotlin.model.Pokemon
import dmax.dialog.SpotsDialog
import com.projectapp2.kotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerPokemonList: RecyclerView
    lateinit var mService : RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : MyPokemonAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService

        recyclerPokemonList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerPokemonList.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()
    }

    private fun getAllMovieList() {
        dialog.show()

        mService.getPokemonList().enqueue(object : Callback<MutableList<Pokemon>> {
            override fun onFailure(call: Call<MutableList<Pokemon>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<MutableList<Pokemon>>, response: Response<MutableList<Pokemon>>) {
                adapter = MyPokemonAdapter(baseContext, response.body() as MutableList<Pokemon>)
                adapter.notifyDataSetChanged()
                recyclerPokemonList.adapter = adapter

                dialog.dismiss()
            }

        })
    }
}
