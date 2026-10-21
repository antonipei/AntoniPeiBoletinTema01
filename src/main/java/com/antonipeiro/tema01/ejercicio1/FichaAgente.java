package com.antonipeiro.tema01.ejercicio1;

import java.time.Instant;

public class FichaAgente {
    public static void main(String[] args) {
        String alias = (args.length > 0) ? args[0] : "Desconocido";

        ProcessHandle currentProcess = ProcessHandle.current();
        long pid = currentProcess.pid();

        String parentPid = currentProcess.parent()
                .map(p -> String.valueOf(p.pid()))
                .orElse("<<no disponible>>");

        String usuario = System.getProperty("user.name");
        Instant instanteInicio = currentProcess.info().startInstant().orElse(null);
        String inicioStr = (instanteInicio != null) ? instanteInicio.toString() : "<<no disponible>>";

        System.out.println("=== FICHA DE AGENTE SECRETO ===");
        System.out.println("Alias: " + alias);
        System.out.println("PID: " + pid);
        System.out.println("PID Padre: " + parentPid);
        System.out.println("Usuario: " + usuario);
        System.out.println("Instante de inicio: " + inicioStr);
    }
}
