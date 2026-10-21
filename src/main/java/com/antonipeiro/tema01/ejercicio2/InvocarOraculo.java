package com.antonipeiro.tema01.ejercicio2;

import java.io.IOException;

public class InvocarOraculo {
    public static void main(String[] args) {
        // cosas para que funcione en IntelliJ la ejecución
        String classpath = System.getProperty("java.class.path");
        String javaHome = System.getProperty("java.home") + "/bin/java";

        // -cp es para especificar que estamos usando un .java y no un class
        ProcessBuilder pb = new ProcessBuilder(
                javaHome,
                "-cp",
                classpath,
                "com.antonipeiro.tema01.ejercicio2.Oraculo",
                "andres",
                "¿que estas haciendo?"
        );

        pb.inheritIO();

        try {
            Process proceso = pb.start();
            int codigoSalida = proceso.waitFor();
            System.out.println("el proceso hijo terminó: " + codigoSalida);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}