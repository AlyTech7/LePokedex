package es.iesrodmarin.lepokedex.database;

import es.iesrodmarin.lepokedex.model.Pokemon;
import es.iesrodmarin.lepokedex.model.TipoPokemon;

import java.util.ArrayList;
import java.util.List;

public class PopulateDatabase {
    public static List<Pokemon> listPokemons = new ArrayList<Pokemon>();

    public static void populate() {
        if (listPokemons.isEmpty()) {
            listPokemons.add(new Pokemon(1, "Pikachu",TipoPokemon.ELECTRIC, 35, 55, 40, 90));
            listPokemons.add(new Pokemon(2, "Charmander", TipoPokemon.FIRE, 39, 52, 43, 65));
            listPokemons.add(new Pokemon(3, "Squirtle", TipoPokemon.WATER, 44, 48, 65, 43));
            listPokemons.add(new Pokemon(4, "Bulbasaur", TipoPokemon.GRASS, 45, 49, 49, 45));
            listPokemons.add(new Pokemon(5, "Eevee", TipoPokemon.FIRE, 55, 55, 50, 55));
            listPokemons.add(new Pokemon(6, "Raichu", TipoPokemon.ELECTRIC, 60, 90, 55, 110));
            listPokemons.add(new Pokemon(7, "Charmeleon", TipoPokemon.FIRE, 58, 64, 58, 80));
            listPokemons.add(new Pokemon(8, "Wartortle", TipoPokemon.WATER, 59, 63, 80, 58));
            listPokemons.add(new Pokemon(9, "Ivysaur", TipoPokemon.GRASS, 60, 62, 63, 60));
            listPokemons.add(new Pokemon(10, "Snorlax", TipoPokemon.GRASS, 160, 110, 65, 30));
            listPokemons.add(new Pokemon(11, "Jolteon", TipoPokemon.ELECTRIC, 65, 65, 60, 130));
            listPokemons.add(new Pokemon(12, "Charizard", TipoPokemon.FIRE, 78, 84, 78, 100));
            listPokemons.add(new Pokemon(13, "Blastoise", TipoPokemon.WATER, 79, 83, 100, 78));
            listPokemons.add(new Pokemon(14, "Venusaur", TipoPokemon.GRASS, 80, 82, 83, 80));
            listPokemons.add(new Pokemon(15, "Meowth", TipoPokemon.ELECTRIC, 40, 45, 35, 90));
            listPokemons.add(new Pokemon(16, "Electabuzz", TipoPokemon.ELECTRIC, 65, 83, 57, 105));
            listPokemons.add(new Pokemon(17, "Vulpix", TipoPokemon.FIRE, 38, 41, 40, 65));
            listPokemons.add(new Pokemon(18, "Psyduck", TipoPokemon.WATER, 50, 52, 48, 55));
            listPokemons.add(new Pokemon(19, "Oddish", TipoPokemon.GRASS, 45, 50, 55, 30));
            listPokemons.add(new Pokemon(20, "Jigglypuff", TipoPokemon.WATER, 115, 45, 20, 20));
            listPokemons.add(new Pokemon(21, "Magnemite", TipoPokemon.ELECTRIC, 25, 35, 70, 45));
            listPokemons.add(new Pokemon(22, "Growlithe", TipoPokemon.FIRE, 55, 70, 45, 60));
            listPokemons.add(new Pokemon(23, "Poliwag", TipoPokemon.WATER, 40, 50, 40, 90));
            listPokemons.add(new Pokemon(24, "Bellsprout", TipoPokemon.GRASS, 50, 75, 35, 40));
            listPokemons.add(new Pokemon(25, "Pidgey", TipoPokemon.FIRE, 40, 45, 40, 56));
            listPokemons.add(new Pokemon(26, "Voltorb", TipoPokemon.ELECTRIC, 40, 30, 50, 100));
            listPokemons.add(new Pokemon(27, "Ponyta", TipoPokemon.FIRE, 50, 85, 55, 90));
            listPokemons.add(new Pokemon(28, "Tentacool", TipoPokemon.WATER, 40, 40, 35, 70));
            listPokemons.add(new Pokemon(29, "Exeggcute", TipoPokemon.GRASS, 60, 40, 80, 40));
            listPokemons.add(new Pokemon(30, "Rattata", TipoPokemon.GRASS, 30, 56, 35, 72));
        }
    }

    public static Pokemon findById(int id) {
        for (Pokemon p : listPokemons) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public static void addPokemon(String nombre, TipoPokemon tipo, int hp, int ataque, int defensa, int velocidad) {
        int newId = 1;
        boolean idFound = false;

        while (!idFound) {
            idFound = true;
            for (Pokemon p : listPokemons) {
                if (p.getId() == newId) {
                    newId++;
                    idFound = false;
                    break;
                }
            }
        }
        if (idFound) {
            Pokemon p = new Pokemon(newId, nombre, tipo, hp, ataque, defensa, velocidad);
            listPokemons.add(p);
        }
    }
}
