package EJERCICIOS;

import java.io.IOException;
import java.io.InputStream;

public class ariketa5 {
	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "tasklist /FI \"IMAGENAME eq Notepad.exe");
		ProcessBuilder pkill = new ProcessBuilder("cmd", "/c", "taskkill /IM Notepad.exe");

		try {
			Process p = pb.start();
			InputStream is = p.getInputStream();
			System.out.println();
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);

			}
			if (c == -1) {
				Process p2 = pkill.start();
				System.out.println("notepad closed");
			}
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}