package es.iesrodmarin.lepokedex.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.iesrodmarin.lepokedex.R;
import es.iesrodmarin.lepokedex.model.Pokemon;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {
    public PokemonAdapter(Context context, int resource, List<Pokemon> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pokemon p = getItem(position);

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.item_pokemon, parent, false);
        }

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        Pokemon p = getItem(position);

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.sp_tipo, parent, false);
        }

        return convertView;
    }
}
