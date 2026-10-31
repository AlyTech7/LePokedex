package es.iesrodmarin.lepokedex.database;

import es.iesrodmarin.lepokedex.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PopulateDatabase {
    public static List<Pokemon> listPokemons = new ArrayList<Pokemon>();

    public static void populate() {
        if (listPokemons.isEmpty()) {
            listPokemons.add(new Pokemon(1, "Pikachu", "Electric", 35, 55, 40, 90));
            listPokemons.add(new Pokemon(2, "Charmander", "Fire", 39, 52, 43, 65));
            listPokemons.add(new Pokemon(3, "Squirtle", "Water", 44, 48, 65, 43));
            listPokemons.add(new Pokemon(4, "Bulbasaur", "Grass", 45, 49, 49, 45));
            listPokemons.add(new Pokemon(5, "Eevee", "Fire", 55, 55, 50, 55));
            listPokemons.add(new Pokemon(6, "Raichu", "Electric", 60, 90, 55, 110));
            listPokemons.add(new Pokemon(7, "Charmeleon", "Fire", 58, 64, 58, 80));
            listPokemons.add(new Pokemon(8, "Wartortle", "Water", 59, 63, 80, 58));
            listPokemons.add(new Pokemon(9, "Ivysaur", "Grass", 60, 62, 63, 60));
            listPokemons.add(new Pokemon(10, "Snorlax", "Grass", 160, 110, 65, 30));
            listPokemons.add(new Pokemon(11, "Jolteon", "Electric", 65, 65, 60, 130));
            listPokemons.add(new Pokemon(12, "Charizard", "Fire", 78, 84, 78, 100));
            listPokemons.add(new Pokemon(13, "Blastoise", "Water", 79, 83, 100, 78));
            listPokemons.add(new Pokemon(14, "Venusaur", "Grass", 80, 82, 83, 80));
            listPokemons.add(new Pokemon(15, "Meowth", "Electric", 40, 45, 35, 90));
            listPokemons.add(new Pokemon(16, "Electabuzz", "Electric", 65, 83, 57, 105));
            listPokemons.add(new Pokemon(17, "Vulpix", "Fire", 38, 41, 40, 65));
            listPokemons.add(new Pokemon(18, "Psyduck", "Water", 50, 52, 48, 55));
            listPokemons.add(new Pokemon(19, "Oddish", "Grass", 45, 50, 55, 30));
            listPokemons.add(new Pokemon(20, "Jigglypuff", "Water", 115, 45, 20, 20));
            listPokemons.add(new Pokemon(21, "Magnemite", "Electric", 25, 35, 70, 45));
            listPokemons.add(new Pokemon(22, "Growlithe", "Fire", 55, 70, 45, 60));
            listPokemons.add(new Pokemon(23, "Poliwag", "Water", 40, 50, 40, 90));
            listPokemons.add(new Pokemon(24, "Bellsprout", "Grass", 50, 75, 35, 40));
            listPokemons.add(new Pokemon(25, "Pidgey", "Fire", 40, 45, 40, 56));
            listPokemons.add(new Pokemon(26, "Voltorb", "Electric", 40, 30, 50, 100));
            listPokemons.add(new Pokemon(27, "Ponyta", "Fire", 50, 85, 55, 90));
            listPokemons.add(new Pokemon(28, "Tentacool", "Water", 40, 40, 35, 70));
            listPokemons.add(new Pokemon(29, "Exeggcute", "Grass", 60, 40, 80, 40));
            listPokemons.add(new Pokemon(30, "Rattata", "Grass", 30, 56, 35, 72));
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

    public static void addPokemon(String nombre, String tipo, int hp, int ataque, int defensa, int velocidad) {
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
