package es.iesrodmarin.lepokedex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import es.iesrodmarin.lepokedex.R;
import es.iesrodmarin.lepokedex.adapter.PokemonAdapter;
import es.iesrodmarin.lepokedex.database.PopulateDatabase;
import es.iesrodmarin.lepokedex.model.Pokemon;

public class MainActivity extends AppCompatActivity {

    Button btnFilter;
    Button btnNewPokemon;
    ListView lvPokemon;
    Spinner spTypeFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFilter = findViewById(R.id.btnFilter);
        btnNewPokemon = findViewById(R.id.btnNewPokemon);
        lvPokemon = findViewById(R.id.lvPokemon);
        spTypeFilter = findViewById(R.id.spTypeFilter);

        ArrayAdapter<Pokemon> adapterDefaultPerson = new PokemonAdapter(MainActivity.this, 0, PopulateDatabase.listPokemons);
        lvPokemon.setAdapter(adapterDefaultPerson);
        spTypeFilter.setAdapter(adapterDefaultPerson);
    }


}
