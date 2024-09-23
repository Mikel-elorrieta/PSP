package EJERCICIO4;


public class DetonadorConRetardo extends Thread {

	private String nombre;
	private int retardo;

	public DetonadorConRetardo(String nombre, int retardo) {

		this.nombre = nombre;
		this.retardo = retardo;

	}
	
	@Override
	public void run() {

		
		while(retardo >= 0 ) {
			System.out.println("La " + nombre + " explotara en :" + retardo);
			retardo--;
		}
		System.out.println("BOOOOOOOOOOM");
		System.out.println("La " + nombre + " ha explotado!");
		
	}

}
