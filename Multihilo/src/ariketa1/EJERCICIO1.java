package ariketa1;

public class EJERCICIO1 extends Thread {
	private String nombre;

	public EJERCICIO1(String nombre) {
		this.nombre = nombre;
	}

	public static void main(String[] args) {

		EJERCICIO1 hilo1 = new EJERCICIO1("1");
		EJERCICIO1 hilo2 = new EJERCICIO1("2");
		
		hilo1.start();
		hilo2.start();
		
		try {
			hilo1.join();
			hilo2.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 1000; i++) {
			System.out.println("Hilo: " + nombre + " - " + i);

		}
		System.out.println("Hilo: " + nombre + " terminado.");
	}
}
