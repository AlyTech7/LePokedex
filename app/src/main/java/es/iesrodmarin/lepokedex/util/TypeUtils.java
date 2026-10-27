package es.iesrodmarin.lepokedex.util;

import es.iesrodmarin.lepokedex.R;

public final class TypeUtils {

    private TypeUtils() {
    }

    public static int getTypeImage(String tipo) {
        if (tipo == null) {
            return R.drawable.ic_energia_electrico;
        }
        switch (tipo.trim().toLowerCase()) {
            case "fire":
            case "fuego":
                return R.drawable.ic_energia_fuego;
            case "water":
            case "agua":
                return R.drawable.ic_energia_agua;
            case "grass":
            case "planta":
                return R.drawable.ic_energia_planta;
            case "electric":
            case "electrico":
            case "eléctrico":
                return R.drawable.ic_energia_electrico;
            default:
                return R.drawable.ic_energia_electrico;
        }
    }

    public static int getTypeColor(String tipo) {
        if (tipo == null) {
            return R.color.type_normal;
        }
        switch (tipo.trim().toLowerCase()) {
            case "fire":
            case "fuego":
                return R.color.type_fire;
            case "water":
            case "agua":
                return R.color.type_water;
            case "grass":
            case "planta":
                return R.color.type_grass;
            case "electric":
            case "electrico":
            case "eléctrico":
                return R.color.type_electric;
            default:
                return R.color.type_normal;
        }
    }
}
