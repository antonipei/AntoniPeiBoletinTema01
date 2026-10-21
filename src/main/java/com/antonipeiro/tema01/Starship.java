package com.antonipeiro.tema01;

public class Starship {
    public static void main(String[] args) {
        String argumento = (args.length > 0) ? args[0] : "Desconocido";

        // obtener variable PLANETA
        String planeta = System.getenv().getOrDefault("PLANETA", "Tierra");

        System.out.println("nave despegando hacia el planeta: " + planeta + " con la misión: " + argumento);
    }
}
