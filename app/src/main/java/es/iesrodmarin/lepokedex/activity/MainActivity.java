package es.iesrodmarin.lepokedex.activity;

import static es.iesrodmarin.lepokedex.database.PopulateDatabase.listPokemons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import es.iesrodmarin.lepokedex.R;
import es.iesrodmarin.lepokedex.adapter.PokemonAdapter;
import es.iesrodmarin.lepokedex.database.PopulateDatabase;
import es.iesrodmarin.lepokedex.model.Pokemon;
import es.iesrodmarin.lepokedex.model.TipoPokemon;

public class MainActivity extends AppCompatActivity {

    Button btnFilter;
    Button btnNewPokemon;
    ListView lvPokemon;
    Spinner spTypeFilter;
    List<Pokemon> shownPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PopulateDatabase.populate();

        btnFilter = findViewById(R.id.btnFilter);
        btnNewPokemon = findViewById(R.id.btnNewPokemon);
        lvPokemon = findViewById(R.id.lvPokemon);
        spTypeFilter = findViewById(R.id.spTypeFilter);

        ArrayAdapter<TipoPokemon> adapterTypes = new ArrayAdapter<>(
                MainActivity.this, android.R.layout.simple_spinner_dropdown_item, TipoPokemon.values());
        spTypeFilter.setAdapter(adapterTypes);

        shownPokemon = listPokemons;
        ArrayAdapter<Pokemon> adapterPokemon = new PokemonAdapter(MainActivity.this, 0, shownPokemon);
        lvPokemon.setAdapter(adapterPokemon);

        lvPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pokemon p = shownPokemon.get(position);

                Intent i = new Intent(MainActivity.this, PokemonDetailActivity.class);
                i.putExtra("pokemon", p);

                startActivity(i);
            }
        });

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TipoPokemon selected = (TipoPokemon) spTypeFilter.getSelectedItem();

                List<Pokemon> filtered = new ArrayList<>();
                for (Pokemon p : listPokemons) {
                    if (p.getTipo() == selected) {
                        filtered.add(p);
                    }
                }

                shownPokemon = filtered;
                lvPokemon.setAdapter(new PokemonAdapter(MainActivity.this, 0, shownPokemon));
            }
        });

        btnNewPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreate = new Intent(MainActivity.this, NewPokemonActivity.class);
                startActivity(intentCreate);
            }
        });
    }
}