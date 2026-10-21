package com.antonipeiro.tema01;

import java.io.IOException;

public class InvocarOraculo {
    public static void main(String[] args) {
        // Ejemplo de ejecución pasando nombre y pregunta con espacios
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "com.antonipei.tema01.Oraculo",
                "paco",
                "¿por que vuelan los cerdos?"
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
