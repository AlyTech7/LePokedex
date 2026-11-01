package es.iesrodmarin.lepokedex.activity;

import static es.iesrodmarin.lepokedex.database.PopulateDatabase.addPokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.iesrodmarin.lepokedex.R;

public class NewPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pokemon);

        EditText etName = findViewById(R.id.etName);
        EditText etHp = findViewById(R.id.etHp);
        EditText etAttack = findViewById(R.id.etAttack);
        EditText etSpeed = findViewById(R.id.etSpeed);
        EditText etDefense = findViewById(R.id.etDefense);
        Spinner spType = findViewById(R.id.spType);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnBack = findViewById(R.id.btnBack);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().trim().isEmpty() ||
                        etHp.getText().toString().trim().isEmpty() ||
                        etAttack.getText().toString().trim().isEmpty() ||
                        etSpeed.getText().toString().trim().isEmpty() ||
                        etDefense.getText().toString().trim().isEmpty()) {

                    Toast.makeText(getApplicationContext(),
                            "Por favor, complete todos los campos.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                String nombre = etName.getText().toString().trim();
                String tipo = spType.getSelectedItem().toString();
                int hp = Integer.parseInt(etHp.getText().toString().trim());
                int ataque = Integer.parseInt(etAttack.getText().toString().trim());
                int defensa = Integer.parseInt(etDefense.getText().toString().trim());
                int velocidad = Integer.parseInt(etSpeed.getText().toString().trim());

                addPokemon(nombre, tipo, hp, ataque, defensa, velocidad);

                Toast.makeText(NewPokemonActivity.this,
                        "Pokémon añadido correctamente",
                        Toast.LENGTH_SHORT).show();

                Intent iMain = new Intent(NewPokemonActivity.this, MainActivity.class);
                startActivity(iMain);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack = new Intent(NewPokemonActivity.this, MainActivity.class);
                startActivity(iBack);
            }
        });
    }
}
