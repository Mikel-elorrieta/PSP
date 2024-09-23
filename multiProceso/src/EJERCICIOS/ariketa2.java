package EJERCICIOS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ariketa2 {
        public static void main(String[] args) {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
            try {
                Process p = pb.start();
                System.out.println("parte 1");
                InputStream is = p.getInputStream();
                System.out.println();
                int c;
                while ((c = is.read()) != -1) {
                    System.out.print((char) c);
                }
//                is.close();
                System.out.println("parte 2");
                // Mostrar linea a linea
                InputStream er = p.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(er));
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                er.close();
                System.out.println("end");
                //al sacar la info de is no hay mas que imprimir
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }