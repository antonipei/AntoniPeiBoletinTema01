package com.antonipeiro.tema01;

public class Mascota {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("java Mascota <nombre> <pasos>");
            System.exit(1);
        }

        String nombre = args[0];
        int pasos = Integer.parseInt(args[1]);
        long pid = ProcessHandle.current().pid();

        for (int i = 1; i <= pasos; i++) {
            System.out.println("PID: " + pid + " | Mascota: " + nombre + " | Paso: " + i);
        }
    }
}