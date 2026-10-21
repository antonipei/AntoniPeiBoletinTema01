package com.antonipeiro.tema01.ejercicio4;

import java.io.IOException;

public class ControlMision {
    public static void main(String[] args) {
        // para que funcione en ejecucion
        String classpath = System.getProperty("java.class.path");
        String javaHome = System.getProperty("java.home") + "/bin/java";

        ProcessBuilder pb = new ProcessBuilder(
                javaHome,
                "-cp",
                classpath,
                "com.antonipeiro.tema01.ejercicio4.Starship",
                "Alfa-7"
        );

        // variable para el proceso hijo
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