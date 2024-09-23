package runtime;

import java.io.IOException;

public class ExecNotepad {
    public static void main(String[] args) {
        System.out.println("Vamos a lanzar el Notepad...");
        String[] infoProceso = {"notepad"};
        try {
            Process proceso = Runtime.getRuntime().exec(infoProceso);
            System.out.println("El ID del proceso es " + proceso.pid());
            int codigoRetorno = proceso.waitFor();
            System.out.println("Fin del Proceso con el codigo " + codigoRetorno);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}