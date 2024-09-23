package es;

import java.io.File;

// Esta clase simula un proceso principal que, ejecuta al proceso secundario
// (proc) y se queda esperando a que termine (waitFor). Se recoge el valor
// de finalización y se muestra por la consola.

public class ProcesoPrincipal {
	public static void main(String[] args) {
		System.out.println("Ejecutamos el proceso secundario...");

		try {
			String[] processInfo = { "java", "es.ProcesoSecundario" };
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(processInfo);

			ProcessBuilder builder = new ProcessBuilder("java", "es.ProcesoSecundario");
			builder.directory(new File("bin"));
			Process process1 = builder.start();

			int valorRetorno = process1.waitFor();

			if (valorRetorno == 0) {
				System.out.println("Proceso secundario finalizado con éxito.");
			} else {
				System.out.println("El proceso secundario ha fallado.");
				System.out.println("Código de error: " + valorRetorno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
