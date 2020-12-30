package com.projectapp2.kotlin.activities

import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.projectapp2.kotlin.adapters.MyAbilityAdapter
import com.projectapp2.kotlin.Common.Common
import com.projectapp2.kotlin.Interface.RetrofitService
import com.projectapp2.kotlin.model.Ability
import dmax.dialog.SpotsDialog
import com.projectapp2.kotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    private lateinit var recyclerAbilityList: RecyclerView
    lateinit var mService : RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : MyAbilityAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService

        recyclerAbilityList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerViewUsers.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()
    }

    private fun getAllMovieList() {
        dialog.show()

        mService.getAbilityList().enqueue(object : Callback<MutableList<Ability>> {
            override fun onFailure(call: Call<MutableList<Ability>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<MutableList<Ability>>, response: Response<MutableList<Ability>>) {
                adapter = MyAbilityAdapter(baseContext, response.body() as MutableList<Ability>)
                adapter.notifyDataSetChanged()
                recyclerAbilityList.adapter = adapter

                dialog.dismiss()
            }

        })
    }
}
