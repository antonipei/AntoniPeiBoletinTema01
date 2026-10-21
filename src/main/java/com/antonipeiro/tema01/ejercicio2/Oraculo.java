package com.antonipeiro.tema01.ejercicio2;

public class Oraculo {
    private static final String[] EXCUSAS = {
            "Estas totalmente en lo cierto.",
            "Estas completamente equivocado.",
            "No estoy seguro totalmente.",
            "Me parece correcto.",
            "Pregunta otra vez.",
            "Me estoy unos macarrones"
    };

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Faltan argumentos (nombre y pregunta).");
            System.exit(1);
        }

        String nombre = args[0];
        String pregunta = args[1];

        // eleccion reproducible se basa en la longitud de la pregunta
        int indice = pregunta.length() % EXCUSAS.length;

        System.out.println("El sabio Oráculo responde a " + nombre + ": \"" + EXCUSAS[indice] + "\"");
        System.exit(0);
    }
}
