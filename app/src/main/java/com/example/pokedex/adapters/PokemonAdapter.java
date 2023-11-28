package com.example.pokedex.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.R;
import com.example.pokedex.models.Pokemons;
import com.example.pokedex.models.Result;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;

import java.util.List;

public class PokemonAdapter  extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder> {
    private List<Result> listp;

    public PokemonAdapter(List<Result> listp) {
        this.listp = listp;
    }

    @NonNull
    @Override
    public PokemonAdapter.PokemonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lyf = LayoutInflater.from(parent.getContext());
        View v = lyf.inflate(R.layout.activity_pokemons_items,parent,false);
        return new PokemonHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapter.PokemonHolder holder, int position) {
        Result p = listp.get(position);
        holder.setData(p);
    }

    @Override
    public int getItemCount() {
        return listp.size();
    }

    public class PokemonHolder extends RecyclerView.ViewHolder {
        TextView names;
        ImageView pke;

        public PokemonHolder(@NonNull View itemView) {
            super(itemView);

            names = itemView.findViewById(R.id.name);
            pke = itemView.findViewById(R.id.pokemon);
        }

        public void setData(Result p) {
            names.setText(p.getName());
            Picasso.get().load(p.getImageUrl()).into(pke);
        }
    }
}
