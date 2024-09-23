package ejercicios_1;

public class ej3 extends Thread {
	private String nombre;

	public ej3(String nombre) {
		this.nombre = nombre;
	}
	





	public static void main(String[] args) {

		//Creamos dos hilos, Persona 1 y Persona 2 y los iniciamos
		
		ej3 hilo1 = new ej3("Persona 1");
		ej3 hilo2 = new ej3("Persona 2");
		

		hilo1.start();
		hilo2.start();
		


	}

	@Override
	public void run() {
		
		

		for (int i = 0; i < 3; i++) {
			System.out.println( nombre  + ",  Operacion: " + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
