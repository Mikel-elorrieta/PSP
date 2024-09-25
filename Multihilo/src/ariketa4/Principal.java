package ariketa4;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		DetonadorConRetardo bomba1 = new DetonadorConRetardo("BOMBA ROJA (1)", 5);
		DetonadorConRetardo bomba2 = new DetonadorConRetardo("BOMBA VERDE (2)", 13);
		DetonadorConRetardo bomba3 = new DetonadorConRetardo("BOMBA AZUL (3)", 50);
		bomba1.start();
		bomba2.start();
		bomba3.start();
		
		bomba1.join();
		bomba2.join();
		bomba3.join();

	}

}
