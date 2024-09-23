package ProcessBuilder;

import java.io.IOException;
import java.util.Map;

public class ProcessBuilderNotepad {
    public static void main(String[] args) {
        System.out.println("Vamos a lanzar el Notepad...");
        String infoProceso = "Notepad.exe";
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(infoProceso);
            Map<String, String> environment = processBuilder.environment();
            System.out.println("Numero de Procesadores: " + environment.get("NUMBER_OF_PROCESSORS") );
            Process proceso = processBuilder.start();
            System.out.println("El ID del proceso es "+proceso.pid());
            int codigoRetorno = proceso.waitFor();
            System.out.println("Fin del Proceso con el codigo " + codigoRetorno);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}