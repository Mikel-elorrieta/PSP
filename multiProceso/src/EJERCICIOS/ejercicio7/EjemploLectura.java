package EJERCICIOS.ejercicio7;

public class EjemploLectura {
	public static void main(String[] args) {
		System.out.println("Proceso EjemploLectura");
		if (args.length > 0) {
			System.out.println("Texto recibido " + args[0]);
		} else {
			System.out.println("No se ha recibido ningún texto.");
		}
	}
}
