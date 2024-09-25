package ariketa3;

public class Principal extends Thread {

	public static void main(String[] args) {
		Escritora escritoraTrue = new Escritora(true);
		Escritora escritoraFalse = new Escritora(false);

		escritoraTrue.start();

		escritoraFalse.start();

	}

}
