package com.example.pokedex;

import com.example.pokedex.models.Pokemons;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonInterface {
    @GET("pokemon?limit=100000&offset=0")
    Call<Pokemons> getPokemon();
}
