package es.iesrodmarin.lepokedex.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.iesrodmarin.lepokedex.R;
import es.iesrodmarin.lepokedex.util.TypeUtils;

/** Pantalla 2: Ver Pokémon */
public class PokemonDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NOMBRE = "nombre";
    public static final String EXTRA_TIPO = "tipo";
    public static final String EXTRA_HP = "hp";
    public static final String EXTRA_ATAQUE = "ataque";
    public static final String EXTRA_DEFENSA = "defensa";
    public static final String EXTRA_VELOCIDAD = "velocidad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvType = findViewById(R.id.tvType);
        TextView tvHp = findViewById(R.id.tvHp);
        TextView tvAttack = findViewById(R.id.tvAttack);
        TextView tvDefense = findViewById(R.id.tvDefense);
        TextView tvSpeed = findViewById(R.id.tvSpeed);
        ImageView ivPokemonType = findViewById(R.id.ivPokemonType);
        Button btnBack = findViewById(R.id.btnBack);

        String nombre = getIntent().getStringExtra(EXTRA_NOMBRE);
        String tipo = getIntent().getStringExtra(EXTRA_TIPO);
        int hp = getIntent().getIntExtra(EXTRA_HP, 0);
        int ataque = getIntent().getIntExtra(EXTRA_ATAQUE, 0);
        int defensa = getIntent().getIntExtra(EXTRA_DEFENSA, 0);
        int velocidad = getIntent().getIntExtra(EXTRA_VELOCIDAD, 0);

        if (nombre == null || nombre.isEmpty()) {
            nombre = "Pikachu";
        }
        if (tipo == null || tipo.isEmpty()) {
            tipo = "Electric";
        }
        if (hp == 0 && ataque == 0) {
            hp = 35;
            ataque = 55;
            defensa = 40;
            velocidad = 90;
        }

        tvName.setText(nombre);
        tvType.setText(getString(R.string.pokemon_type_format, tipo));
        tvHp.setText("HP: " + hp);
        tvAttack.setText("Attack: " + ataque);
        tvDefense.setText("Defense: " + defensa);
        tvSpeed.setText("Speed: " + velocidad);

        // Cambia la bola según el tipo (fuego, agua, planta, eléctrico)
        ivPokemonType.setImageResource(TypeUtils.getTypeImage(tipo));

        btnBack.setOnClickListener(v -> finish());
    }
}
