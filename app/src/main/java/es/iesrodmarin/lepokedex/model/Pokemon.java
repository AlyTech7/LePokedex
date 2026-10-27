package es.iesrodmarin.lepokedex.model;

public class Pokemon {
    private String nombre;
    private String tipo;
    private int hp;
    private int ataque;
    private int defensa;
    private int velocidad;

    public Pokemon(String nombre, String tipo, int hp, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getHp() {
        return hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public String toString() {
        return "";
    }
}
