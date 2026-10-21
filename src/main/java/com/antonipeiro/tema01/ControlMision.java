package com.antonipeiro.tema01;

import java.io.IOException;

public class ControlMision {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "com.antonipeiro.tema01.Starship", "Alfa-7");

        // Añadir variable de entorno exclusiva para el proceso hijo
        pb.environment().put("PLANETA", "Marte");
        pb.inheritIO();

        try {
            Process proceso = pb.start();
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}