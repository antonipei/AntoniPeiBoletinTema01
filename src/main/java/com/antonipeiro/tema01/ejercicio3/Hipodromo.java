package com.antonipeiro.tema01.ejercicio3;

import java.io.IOException;
import java.util.List;

public class Hipodromo {
    public static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");
        String javaHome = System.getProperty("java.home") + "/bin/java";

        List<ProcessBuilder> procesos = List.of(
                new ProcessBuilder(javaHome, "-cp", classpath, "com.antonipeiro.tema01.ejercicio3.Mascota", "tortuga", "5"),
                new ProcessBuilder(javaHome, "-cp", classpath, "com.antonipeiro.tema01.ejercicio3.Mascota", "liebre", "5"),
                new ProcessBuilder(javaHome, "-cp", classpath, "com.antonipeiro.tema01.ejercicio3.Mascota", "perro", "5")
        );

        try {
            List<Process> listadoProcesos = new java.util.ArrayList<>();

            // Lanzar todas las mascotas antes de esperar
            for (ProcessBuilder pb : procesos) {
                pb.inheritIO();
                listadoProcesos.add(pb.start());
            }

            // Anunciar llegadas conforme van terminando
            System.out.println("--- COMIENZA LA CARRERA ---");
            while (!listadoProcesos.isEmpty()) {
                for (int i = 0; i < listadoProcesos.size(); i++) {
                    Process p = listadoProcesos.get(i);
                    if (!p.isAlive()) {
                        System.out.println("meta" + p.exitValue());
                        listadoProcesos.remove(i);
                        break;
                    }
                }
                Thread.sleep(50);
            }
            System.out.println("--- FIN DE LA CARRERA ---");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}