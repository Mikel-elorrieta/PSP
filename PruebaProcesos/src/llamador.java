import java.io.File;
import java.io.IOException;

public class llamador {

    public static void main(String[] args) {
        ProcessBuilder builder;

        // Especifica el classpath correctamente para el paquete por defecto
        builder = new ProcessBuilder("java", "-cp", "../bin", "receptor");
        
        try {
            Process process = builder.start();

            // Lee la salida del proceso receptor
            java.io.InputStream inputStream = process.getInputStream();
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Imprime lo que el proceso hijo produce
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
