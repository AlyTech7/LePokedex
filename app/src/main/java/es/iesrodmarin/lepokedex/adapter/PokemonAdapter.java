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
        // Position es el numero de fila que se va a generar
        Pokemon p = getItem(position);

        // Comprobamos que no haya ninguna nueva fila disponible
        if (convertView == null) {
            // Saco el layoutInflater del context (activity)
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            /* Campos del inflate
            1º Context: XML usado de plantilla
            2º Parent: Padre del elemento (ListView)
            3º False: Para crear el padre antes que el hijo
             */
            convertView = layoutInflater.inflate(R.layout.list_persons, parent, false);
        }
        // Setear informacion de los usuarios
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvSurname = convertView.findViewById(R.id.tvSurname);
        TextView tvEmail = convertView.findViewById(R.id.tvEmail);
        tvName.setText(p.getName());
        tvSurname.setText(p.getSurname());
        tvEmail.setText(p.getEmail());

        return convertView;
    }

    // Define cómo se ven los elementos en la lista desplegable cuando tocas el Spinner.
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        // Position es el numero de fila que se va a generar
        Pokemon p = getItem(position);

        // Comprobamos que no haya ninguna nueva fila disponible
        if (convertView == null) {
            // Saco el layoutInflater del context (activity)
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            /* Campos del inflate
            1º Context: XML usado de plantilla
            2º Parent: Padre del elemento (ListView)
            3º False: Para crear el padre antes que el hijo
             */
            convertView = layoutInflater.inflate(R.layout.spinner_person, parent, false);
        }
        // Setear informacion de los usuarios
        TextView tvDataPersons = convertView.findViewById(R.id.tvDataPersons);
        tvDataPersons.setText(p.getName() + " " + p.getSurname() + " (" + p.getEmail() + ")");

        return convertView;
    }
}
