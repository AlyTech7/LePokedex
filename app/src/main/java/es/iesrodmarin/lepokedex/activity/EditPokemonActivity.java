package es.iesrodmarin.lepokedex.activity;

import static es.iesrodmarin.lepokedex.database.PopulateDatabase.findById;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.iesrodmarin.lepokedex.R;
import es.iesrodmarin.lepokedex.model.Pokemon;
import es.iesrodmarin.lepokedex.model.TipoPokemon;

public class EditPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pokemon);

        Intent intentOfDetail = getIntent();
        Pokemon p = (Pokemon) intentOfDetail.getSerializableExtra("pokemon");

        EditText etName = findViewById(R.id.etName);
        EditText etHp = findViewById(R.id.etHp);
        EditText etAttack = findViewById(R.id.etAttack);
        EditText etSpeed = findViewById(R.id.etSpeed);
        EditText etDefense = findViewById(R.id.etDefense);
        Spinner spType = findViewById(R.id.spType);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnBack = findViewById(R.id.btnBack);

        ArrayAdapter<TipoPokemon> adapterTypes = new ArrayAdapter<>(
                EditPokemonActivity.this, android.R.layout.simple_spinner_dropdown_item, TipoPokemon.values());
        spType.setAdapter(adapterTypes);

        etName.setText(p.getNombre());
        etHp.setText(String.valueOf(p.getHp()));
        etAttack.setText(String.valueOf(p.getAtaque()));
        etSpeed.setText(String.valueOf(p.getVelocidad()));
        etDefense.setText(String.valueOf(p.getDefensa()));
        spType.setSelection(p.getTipo().ordinal());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().isEmpty() ||
                        etHp.getText().toString().isEmpty() ||
                        etAttack.getText().toString().isEmpty() ||
                        etSpeed.getText().toString().isEmpty() ||
                        etDefense.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(),
                            "Por favor, complete todos los campos.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Pokemon pokemonOfBD = findById(p.getId());

                pokemonOfBD.setNombre(etName.getText().toString());
                pokemonOfBD.setHp(Integer.parseInt(etHp.getText().toString()));
                pokemonOfBD.setAtaque(Integer.parseInt(etAttack.getText().toString()));
                pokemonOfBD.setVelocidad(Integer.parseInt(etSpeed.getText().toString()));
                pokemonOfBD.setDefensa(Integer.parseInt(etDefense.getText().toString()));
                pokemonOfBD.setTipo((TipoPokemon) spType.getSelectedItem());

                Toast.makeText(EditPokemonActivity.this,
                        "Pokémon editado correctamente",
                        Toast.LENGTH_SHORT).show();

                Intent iMain = new Intent(EditPokemonActivity.this, MainActivity.class);
                startActivity(iMain);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack = new Intent(EditPokemonActivity.this, MainActivity.class);
                startActivity(iBack);
            }
        });
    }
}