package EJERCICIOS.ejercicio7;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Llamador {
    public static void main(String[] args) {
        try {
            String texto = "sin texto";
            if (args.length > 0) {
                texto = args[0];
            }
            System.out.println("Llamando al proceso con texto: " + texto);
            
            ProcessBuilder pbs = new ProcessBuilder("java", "EJERCICIOS.ejercicio7.EjemploLectura", texto);
            
            // Directorio 
            pbs.directory(new File("bin"));
            
            Process process = pbs.start();

            // Captura la salida
            BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;
            while ((linea = outputReader.readLine()) != null) {
                System.out.println(linea);
            }

            // error
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String errorLinea;
            while ((errorLinea = errorReader.readLine()) != null) {
                System.err.println("Error: " + errorLinea);
            }

            // esperando a que termine
            int exitCode = process.waitFor();
            System.out.println("El proceso terminó con código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}




