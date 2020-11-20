package com.pokemaps.pokemap.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pokemaps.pokemap.R;
import com.pokemaps.pokemap.model.Pokemones;

import java.util.List;

public class AdaptadorPokemones extends BaseAdapter {

    private Context contexto;
    private List<Pokemones> listapokemon;

    public AdaptadorPokemones(Context context, List<Pokemones> listapokemon)
    {
        this.contexto = context;
        this.listapokemon = listapokemon;
    }

    @Override
    public int getCount() {
        return listapokemon.size();
    }

    @Override
    public Object getItem(int position) {
        return listapokemon.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflate = LayoutInflater.from(contexto);
        vista = inflate.inflate(R.layout.item_spinner,null);

        ImageView imagen = (ImageView) vista.findViewById(R.id.iv_poke);
        TextView descripcion = (TextView) vista.findViewById(R.id.tv_poke);

        imagen.setImageResource(listapokemon.get(position).getImagen_pokemon());
        descripcion.setText(listapokemon.get(position).getNombre_pokemon());

        return vista;
    }
}
