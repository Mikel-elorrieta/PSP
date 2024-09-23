package EJERCICIOS;

import java.io.IOException;
import java.io.InputStream;

public class ariketa4 {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("tasklist");
		try {
			Process p = pb.start();
			InputStream is = p.getInputStream();
			System.out.println();
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
