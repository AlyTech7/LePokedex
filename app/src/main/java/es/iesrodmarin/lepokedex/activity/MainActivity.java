package es.iesrodmarin.lepokedex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import es.iesrodmarin.lepokedex.R;

/** Pantalla 1: Lista */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNewPokemon = findViewById(R.id.btnNewPokemon);
        btnNewPokemon.setOnClickListener(v ->
                startActivity(new Intent(this, NewPokemonActivity.class)));
    }
}
