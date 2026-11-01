package es.iesrodmarin.lepokedex.adapter;

import android.content.Context;
import android.graphics.Color;
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

        // Setear informacion del Pokemon
        TextView tvItemName = convertView.findViewById(R.id.tvItemName);
        TextView tvItemHp = convertView.findViewById(R.id.tvItemHp);
        TextView tvItemAttack = convertView.findViewById(R.id.tvItemAttack);
        TextView tvItemDefense = convertView.findViewById(R.id.tvItemDefense);
        TextView tvItemSpeed = convertView.findViewById(R.id.tvItemSpeed);

        tvItemName.setText(p.getNombre());
        tvItemHp.setText("HP: " + p.getHp());
        tvItemAttack.setText("Atk: " + p.getAtaque());
        tvItemDefense.setText("Def: " + p.getDefensa());
        tvItemSpeed.setText("Spd: " + p.getVelocidad());

        int color;
        switch (p.getTipo()) {
            case ELECTRIC:
                color = Color.parseColor("#FFEB3B"); // Amarillo
                break;
            case FIRE:
                color = Color.parseColor("#EF5350"); // Rojo
                break;
            case WATER:
                color = Color.parseColor("#64B5F6"); // Azul
                break;
            case GRASS:
                color = Color.parseColor("#81C784"); // Verde
                break;
            default:
                color = Color.parseColor("#E0E0E0"); // Gris
                break;
        }
        convertView.getBackground().mutate().setTint(color);

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