package com.projectapp2.kotlin.Interface

import com.projectapp2.kotlin.model.Pokemon
import com.projectapp2.kotlin.model.Ability
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("pokemon.json")
    fun getPokemonList(): Call<MutableList<Pokemon>>

    @GET("ability.json")
    fun getAbilityList(): Call<MutableList<Ability>>
}