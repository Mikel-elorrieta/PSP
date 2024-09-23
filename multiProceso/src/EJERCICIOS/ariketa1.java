package EJERCICIOS;


import java.io.IOException;
import java.util.Map;

public class ariketa1 {
    public static void main(String[] args) {
        System.out.println("Vamos a lanzar el Notepad...");
        String infoProceso = "Notepad.exe";
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(infoProceso);
            
            Process proceso = processBuilder.start();
           
            System.out.println("Fin del Proceso");
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}
