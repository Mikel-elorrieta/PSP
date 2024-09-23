package ejercicio3;

public class Escritora extends Thread {

	private Boolean isAlive;

	public Escritora(Boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public void run() {
		if (isAlive) {
			for (int i = 0; i < 30; i++) {
				System.out.println("Idazten : " + i);

			}
		} else {

			for (char letra = 'a'; letra <= 'z'; letra++) {
				System.out.println("Idazten : " + letra);

			}
		}
	}

}
