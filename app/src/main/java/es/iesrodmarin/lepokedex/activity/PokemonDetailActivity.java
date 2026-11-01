package es.iesrodmarin.lepokedex.activity;

import static es.iesrodmarin.lepokedex.database.PopulateDatabase.listPokemons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.iesrodmarin.lepokedex.R;
import es.iesrodmarin.lepokedex.model.Pokemon;
import es.iesrodmarin.lepokedex.util.TypeUtils;

public class PokemonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        Intent i = getIntent();

        TextView tvName = findViewById(R.id.tvName);
        TextView tvType = findViewById(R.id.tvType);
        TextView tvHp = findViewById(R.id.tvHp);
        TextView tvAttack = findViewById(R.id.tvAttack);
        TextView tvDefense = findViewById(R.id.tvDefense);
        TextView tvSpeed = findViewById(R.id.tvSpeed);
        ImageView ivPokemonType = findViewById(R.id.ivPokemonType);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnBack = findViewById(R.id.btnBack);

        Pokemon p = (Pokemon) i.getSerializableExtra("pokemon");
        if (p == null) {
            finish();
            return;
        }

        tvName.setText(p.getNombre());
        tvType.setText(getString(R.string.pokemon_type_format, p.getTipo()));
        tvHp.setText("HP: " + p.getHp());
        tvAttack.setText("Attack: " + p.getAtaque());
        tvDefense.setText("Defense: " + p.getDefensa());
        tvSpeed.setText("Speed: " + p.getVelocidad());
        ivPokemonType.setImageResource(TypeUtils.getTypeImage(p.getTipo()));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack = new Intent(PokemonDetailActivity.this, MainActivity.class);
                startActivity(iBack);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPokemons.remove(p);
                Toast.makeText(PokemonDetailActivity.this,
                        "Pokémon eliminado correctamente",
                        Toast.LENGTH_SHORT).show();
                Intent iDelete = new Intent(PokemonDetailActivity.this, MainActivity.class);
                startActivity(iDelete);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEdit = new Intent(PokemonDetailActivity.this, EditPokemonActivity.class);
                iEdit.putExtra("pokemon", p);
                startActivity(iEdit);
            }
        });
    }
}
