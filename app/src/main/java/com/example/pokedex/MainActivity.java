package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pokedex.adapters.PokemonAdapter;
import com.example.pokedex.models.Pokemons;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        getPokemon();

    }
    private void getPokemon() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PokemonInterface pokemonRequestInterface = retrofit.create(PokemonInterface.class);

        Call<Pokemons> peticion = pokemonRequestInterface.getPokemon();
        peticion.enqueue(new Callback<Pokemons>() {

            @Override
            public void onResponse(Call<Pokemons> call, Response<Pokemons> response) {
                if(response.isSuccessful()){
                    Pokemons pokemons = response.body();
                    PokemonAdapter pokemonAdapter = new PokemonAdapter(pokemons.getResults().getClass());
                    recyclerView.setAdapter(pokemonAdapter);
                }
            }

            @Override
            public void onFailure(Call<Pokemons> call, Throwable t) {

            }
        });
    }
}